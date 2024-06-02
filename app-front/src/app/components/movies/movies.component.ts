import {Component, OnInit} from '@angular/core';
import {MovieService} from "../../services/movie.service";
import {Movie} from "../../models/movie";
import {RouterLink} from "@angular/router";
import {NgbPopover} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-movies',
  standalone: true,
  imports: [
    RouterLink,
    NgbPopover
  ],
  templateUrl: './movies.component.html',
  styleUrl: './movies.component.css'
})
export class MoviesComponent implements OnInit{

  movies? : Movie[];

  constructor(private movieService: MovieService) {}

  ngOnInit(): void {
    this.getAllMovies();
  }

  getAllMovies(): void {
    this.movieService.getAll().subscribe({
      next: (data) => {
        this.movies = data;
        //console.log(data);
      }
    });
  }

}
