import {Movie} from "./movie";
import {User} from "./user.model";

export interface Review {
  id?: any;
  rating?: any;
  review?: string;
  likes?: any;
  user?: User;
  movie?: Movie;
}
