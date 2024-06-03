import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Movie} from "../models/movie";
import {Review} from "../models/review";

const baseUrl = 'http://localhost:8081/review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http: HttpClient) { }

  getAllByMovie(id: number): Observable<Review[]> {
    return this.http.get<Review[]>(`${baseUrl}/show/all/by_movie/${id}`);
  }

  post(data: any): Observable<any> {
    return this.http.post(`${baseUrl}/add`, data);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${baseUrl}/remove/${id}`);
  }
}
