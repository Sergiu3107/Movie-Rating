import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ReviewService} from "../../services/review.service";
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Review} from '../../models/review';
import {AuthService} from "../../services/auth.service";
import {MovieService} from "../../services/movie.service";
import {Movie} from "../../models/movie";
import {User} from "../../models/user.model";
import {MoviePageComponent} from "../movie-page/movie-page.component";
import {HttpClient} from "@angular/common/http";
import {NgbRating} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-post-review',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgbRating
  ],
  templateUrl: './post-review.component.html',
  styleUrl: './post-review.component.css'
})
export class PostReviewComponent implements OnInit {

  idMovie?: any;
  isLoggedIn: boolean = false;

  user?: User;
  movie?: Movie;

  rating = 0;
  submitted = false;
  reviewForm: FormGroup;

  constructor(private route: ActivatedRoute,
              private reviewService: ReviewService,
              private movieService: MovieService,
              private formBuilder: FormBuilder,
              private authService: AuthService) {
    this.reviewForm = this.formBuilder.group({
      reviewText: new FormControl('', Validators.minLength(10)),
    })
  }

  ngOnInit() {
    this.idMovie = this.route.snapshot.params['id'];
    this.user = this.authService.getCurrentUser();
    this.isLoggedIn = this.authService.getIsLoggedIn();

    this.movieService.getById(this.idMovie).subscribe({
      next: data => {
        this.movie = data;
      }
    });

    this.reviewForm = this.formBuilder.group({
      reviewText: ['', Validators.minLength(10)],
    });

    if (!this.isLoggedIn) {
      this.reviewForm.get('reviewText')?.disable()
    } else {
      this.reviewForm.get('reviewText')?.enable();
    }

  }

  onPost(): void {
    this.submitted = true;

    const data: Review = {
      rating: this.rating,
      review: this.reviewForm.value.reviewText ?? '',
      likes: 0,
      user: this.user,
      movie: this.movie
    }

    console.log(data);

  }
}
