import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {MovieService} from "../../services/movie.service";
import {Movie} from "../../models/movie";
import {NavbarComponent} from "../navbar/navbar.component";
import {ReviewService} from "../../services/review.service";
import {Review} from "../../models/review";
import {ReviewsComponent} from "../reviews/reviews.component";
import {NgbRating} from "@ng-bootstrap/ng-bootstrap";
import {PostReviewComponent} from "../post-review/post-review.component";

@Component({
  selector: 'app-movie-page',
  standalone: true,
  imports: [
    NavbarComponent,
    ReviewsComponent,
    NgbRating,
    PostReviewComponent
  ],
  templateUrl: './movie-page.component.html',
  styleUrl: './movie-page.component.css'
})
export class MoviePageComponent implements OnInit {

  id?: any;
  movie?: Movie;
  rating: any;
  constructor(private route: ActivatedRoute, private movieService: MovieService) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.movieService.getById(this.id).subscribe({
        next: data => {
          this.movie = data;
          this.rating = data.rating;
          console.log(this.rating);
        },
      }
    );
  }

  ariaValueText(current: number, max: number) {
    return `${current} out of ${max} hearts`;
  }
}
