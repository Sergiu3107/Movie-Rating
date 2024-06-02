import { Injectable } from '@angular/core';
import {User} from "../models/user.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  static currentUser : User | null;
  static isLoggedIn: boolean = false;

  constructor() { }

  setCurrentUser(user : any) {
    AuthService.currentUser = user;
  }

  getCurrentUser():any {
    return AuthService.currentUser;
  }

  getIsLoggedIn():any {
    return AuthService.isLoggedIn;
  }

  login(user:any):void {
    this.setCurrentUser(user);
    AuthService.isLoggedIn = true;
  }

  logout():void {
    this.setCurrentUser(null);
    AuthService.isLoggedIn = false;
  }
}
