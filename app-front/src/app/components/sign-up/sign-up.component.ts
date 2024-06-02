import {Component, OnInit} from '@angular/core';
import {RouterLink} from "@angular/router";
import {AbstractControl, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {User} from "../../models/user.model";
import Validation from "../../utils/validation";
import {NgClass, NgIf, NgOptimizedImage} from "@angular/common";

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [
    RouterLink,
    ReactiveFormsModule,
    NgClass,
    NgIf,
    NgOptimizedImage,
  ],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent implements OnInit{

  singUpForm = new FormGroup({
    username: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    confirmPassword: new FormControl(''),
  });
  submitted = false;

  constructor(private userService: UserService, private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.singUpForm = this.formBuilder.group({
      username: [
        '',
        [
          Validators.required,
          Validators.minLength(6),
          Validators.maxLength(20),
        ],
      ],
      email: [
        '',
        [
          Validators.required,
          Validators.email,
        ],
      ],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(8),
          Validators.maxLength(30),
        ],
      ],
      confirmPassword: [
        '',
        [
          Validators.required,
          Validators.minLength(8),
          Validators.maxLength(30),
        ],
      ],
    },
      {
        validators: [Validation.match('password', 'confirmPassword')]
      });
  }

  registerUser() {

    const data: User = {
      username: this.singUpForm.value.username ?? '',
      email: this.singUpForm.value.email ?? '',
      password: this.singUpForm.value.password ?? '',
      status: 'regular' ?? undefined,
    }

    this.userService.post(data).subscribe({
      next: (res) => {
        console.log('User signed up successfully');
      },
      error: (e) => console.error('User signed up failed'),
    });

    this.submitted = false;
    this.singUpForm.reset();
  }

  get f(): { [key: string]: AbstractControl } {
    return this.singUpForm.controls;
  }

  onSubmit(): void {
    this.submitted = true;

    if (this.singUpForm.invalid) {
      this.logValidationErrors();
      return;
    }

    this.registerUser();
  }

  private logValidationErrors(): void {
    Object.keys(this.f).forEach(key => {
      const controlErrors = this.f[key].errors;
      if (controlErrors != null) {
        Object.keys(controlErrors).forEach(errorKey => {
          console.error(`Validation error in ${key}: ${errorKey}`);
        });
      }
    });
  }


}
