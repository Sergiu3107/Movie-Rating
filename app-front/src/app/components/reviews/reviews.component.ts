import {Component, OnInit} from '@angular/core';
import {Movie} from "../../models/movie";
import {Review} from "../../models/review";
import {ActivatedRoute} from "@angular/router";
import {MovieService} from "../../services/movie.service";
import {ReviewService} from "../../services/review.service";

@Component({
  selector: 'app-reviews',
  standalone: true,
  imports: [],
  templateUrl: './reviews.component.html',
  styleUrl: './reviews.component.css'
})
export class ReviewsComponent implements OnInit{

  id?: any;
  reviews?: Review[];

  constructor(private route: ActivatedRoute, private reviewService: ReviewService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.reviewService.getAllByMovie(this.id).subscribe({
        next: data => {
          this.reviews = data;
          // console.log(data);
        },
      }
    );

  }

}
