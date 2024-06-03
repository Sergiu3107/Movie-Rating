import {Component, OnInit} from '@angular/core';
import {RouterLink} from "@angular/router";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {AuthService} from "../../services/auth.service";
import {User} from "../../models/user.model";

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    RouterLink, NgbModule
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {

  logged = false;
  user: User | null = null;

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
    this.logged = this.authService.getIsLoggedIn();
    this.user = this.authService.getCurrentUser();
    console.log(this.user);
  }

  logout(): void {
    this.authService.logout();
  }
}
