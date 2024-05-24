import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user.model";

const baseUrl = 'http://localhost:8081/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<User[]> {
    console.log(baseUrl)
    return this.http.get<User[]>(`${baseUrl}/show/all`);
  }
}
