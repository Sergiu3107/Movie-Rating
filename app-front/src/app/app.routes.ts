import {Routes} from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {SignUpComponent} from "./components/sign-up/sign-up.component";
import {LogInComponent} from "./components/log-in/log-in.component";
import {MoviePageComponent} from "./components/movie-page/movie-page.component";
import {MoviesComponent} from "./components/movies/movies.component";

export const routes: Routes = [
  {path: 'home' ,component: HomeComponent},
  {path: 'movies-list', component: MoviesComponent},
  {path: 'movie/:id', component: MoviePageComponent},
  {path: 'sign-up', component: SignUpComponent},
  {path: 'log-in', component: LogInComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},

];
