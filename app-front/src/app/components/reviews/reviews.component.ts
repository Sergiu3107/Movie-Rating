import {Component, OnInit} from '@angular/core';
import {Movie} from "../../models/movie";
import {Review} from "../../models/review";
import {ActivatedRoute, Router} from "@angular/router";
import {MovieService} from "../../services/movie.service";
import {ReviewService} from "../../services/review.service";
import {NgbRating} from "@ng-bootstrap/ng-bootstrap";
import {AuthService} from "../../services/auth.service";
import {User} from "../../models/user.model";

@Component({
  selector: 'app-reviews',
  standalone: true,
  imports: [
    NgbRating
  ],
  templateUrl: './reviews.component.html',
  styleUrl: './reviews.component.css'
})
export class ReviewsComponent implements OnInit {

  id?: any;
  user?: User;
  reviews?: Review[];
  isAdmin = false;

  constructor(private route: ActivatedRoute, private router: Router,private reviewService: ReviewService,
              private authService: AuthService) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.user = this.authService.getCurrentUser() ?? undefined;

    this.isAdmin = this.user?.status === 'admin';

    this.reviewService.getAllByMovie(this.id).subscribe({
        next: data => {
          this.reviews = data;
        },
      }
    );
  }

  deleteReview(id: any) {
    this.reviewService.delete(id).subscribe({
      next: (res) => {
        this.router.navigate([this.router.url])
          .then(() => {
            window.location.reload();
          });
      }
    })
  }



}
