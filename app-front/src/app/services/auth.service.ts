import { Injectable } from '@angular/core';
import { User } from "../models/user.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  static currentUser: User | null;
  static isLoggedIn: boolean = false;

  constructor() {
    this.loadFromLocalStorage();
  }

  private loadFromLocalStorage() {
    const storedUser = localStorage.getItem('currentUser');
    const storedIsLoggedIn = localStorage.getItem('isLoggedIn');

    if (storedUser && storedIsLoggedIn) {
      AuthService.currentUser = JSON.parse(storedUser);
      AuthService.isLoggedIn = JSON.parse(storedIsLoggedIn);
    }
  }

  private saveToLocalStorage() {
    localStorage.setItem('currentUser', JSON.stringify(AuthService.currentUser));
    localStorage.setItem('isLoggedIn', JSON.stringify(AuthService.isLoggedIn));
  }

  setCurrentUser(user: User | null) {
    AuthService.currentUser = user;
    this.saveToLocalStorage();
  }

  getCurrentUser(): User | null {
    return AuthService.currentUser;
  }

  getIsLoggedIn(): boolean {
    return AuthService.isLoggedIn;
  }

  login(user: User): void {
    this.setCurrentUser(user);
    AuthService.isLoggedIn = true;
    this.saveToLocalStorage();
  }

  logout(): void {
    this.setCurrentUser(null);
    AuthService.isLoggedIn = false;
    this.saveToLocalStorage();
  }
}
