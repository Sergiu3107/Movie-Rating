import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Movie} from "../models/movie";
import {Observable} from "rxjs";

const baseUrl = 'http://localhost:8081/movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Movie[]> {
    return this.http.get<Movie[]>(`${baseUrl}/show/all`);
  }

  getById(id: number): Observable<Movie> {
    return this.http.get<Movie>(`${baseUrl}/show/${id}`);
  }
}
