import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from "@angular/router";
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";
import { UserService } from "../../services/user.service";
import { User } from "../../models/user.model";
import { AuthService } from "../../services/auth.service";
import { NgClass } from "@angular/common";

@Component({
  selector: 'app-log-in',
  standalone: true,
  imports: [
    RouterLink,
    ReactiveFormsModule,
    NgClass,
  ],
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {
  notAnUser = false;
  notMatchPass = false;
  submitted = false;

  logInForm: FormGroup;

  constructor(private userService: UserService, private formBuilder: FormBuilder, private authService: AuthService,
              private router: Router) {
    this.logInForm = this.formBuilder.group({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {
    this.logInForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  onSubmit(): void {
    this.submitted = true;

    const data: User = {
      username: this.logInForm.value.username ?? '',
      password: this.logInForm.value.password ?? '',
    }

    this.login(data.username, data.password);
  }

  private login(username: string | undefined, password: string | undefined): void {
    this.notAnUser = false;
    this.notMatchPass = false;

    if (username && password) {
      this.userService.getUserByUsername(username).subscribe({
        next: (user: User) => {
          if (!user) {
            this.notAnUser = true;
          } else if (user.password !== password) {
            this.notMatchPass = true;
          } else {
            this.authService.login(user);
            console.log("User logged in successfully");
            this.router.navigate(['/home']);
          }
        },
        error: () => {
          this.notAnUser = true;
        }
      });
    }
  }
}
