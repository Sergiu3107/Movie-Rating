
# Movie Rating App Documentation

## Introduction

Welcome to the Movie Rating App documentation. This application provides users with a platform to share their reviews and ratings for movies they have watched. Additionally, it offers features such as movie recommendations based on user ratings and administrative controls for managing user reviews.

## Features

### User Management
- **Registration:** Users can register for an account, providing necessary information to access the platform.
- **Authentication:** Secure authentication mechanisms ensure that only registered users can access their accounts.
- **User Roles:** Differentiate between regular users and administrators. Administrators have additional privileges, such as deleting any user review.

### Movie Management
- **Browse Movies:** Users can view a comprehensive list of movies available in the system.
- **Add/Delete Movies:** Administrators can add new movies to the system and delete existing ones.
- **Update Movie Details:** Update movie information, such as title, genre, or release year.

### Review Management
- **User Reviews:** Users can add, delete, and update their reviews for movies they have watched.
- **Like Reviews:** Users can express appreciation for reviews by liking them, contributing to community engagement.
- **Top Reviews:** Display the top 5 reviews for each movie based on user ratings.

### Recommendation System
- **Personalized Recommendations:** Based on the user's previously rated movies, the system suggests similar movies the user might enjoy.
- **Algorithmic Recommendations:** Utilize advanced algorithms to provide tailored movie suggestions for each user.

## Relationships

The Movie Rating App database consists of three main tables: Users, Movies, and Reviews. These tables are interconnected to establish meaningful relationships between the entities.

### Users to Reviews (One-to-Many)
- Each user can write multiple reviews.
- Each review is associated with one user.

### Movies to Reviews (One-to-Many)
- Each movie can have multiple reviews.
- Each review is associated with one movie.

#### Entity Relationship Diagram

The following diagram illustrates the relationships between the database tables:

![Movie_Rating_DB](https://github.com/Sergiu3107/Movie-Rating/assets/62149434/c10995ce-9e8d-4fcb-ad45-df261278bd19)

#### UML Class Diagram
![movie_rating](https://github.com/Sergiu3107/Movie-Rating/assets/62149434/f439b991-459b-4ffb-b0fd-8b7db16a0188)

#### Use Case Diagram
![Untitled](https://github.com/Sergiu3107/Movie-Rating/assets/62149434/f4189026-8282-46ed-bca8-aba481e189d4)

### Users
- Stores information about registered users, including username, email, and role.
- Supports differentiation between regular users and administrators.

### Movies
- Contains a catalog of movies available in the system, along with basic information such as title, genre, and average rating.
- Supports CRUD operations for managing movies.

### Reviews
- Stores user-generated reviews for movies, including comments and ratings.
- Establishes relationships between users, movies, and reviews.

## Endpoints

The application exposes a set of RESTful endpoints to interact with the system. Here is a summary of available endpoints:

### Movie Endpoints
- **GET /movie/show/all:** Retrieve all movies available in the system.
- **GET /movie/show/{id}:** Retrieve details of a specific movie by its ID.
- **DELETE /movie/remove/{id}:** Delete a movie from the system.
- **POST /movie/add:** Add a new movie to the system.
- **PUT /movie/update/{id}:** Update details of an existing movie.

### Review Endpoints
- **GET /review/show/all:** Retrieve all reviews available in the system.
- **GET /review/show/{id}:** Retrieve details of a specific review by its ID.
- **DELETE /review/remove/{id}:** Delete a review from the system.
- **POST /review/add:** Add a new review to the system.
- **PUT /review/update/{id}:** Update details of an existing review.
- **PUT /review/like/{id}:** Increment the number of likes for a specific review.

### User Endpoints
- **GET /user/show/all:** Retrieve all users registered in the system.
- **GET /user/show/{id}:** Retrieve details of a specific user by their ID.
- **DELETE /user/remove/{id}:** Delete a user from the system.
- **POST /user/add:** Register a new user in the system.
- **PUT /user/update/{id}:** Update details of an existing user.

## Front-end
#### Technologies
- Angular 17
- Bootstrap 5
- ngBootstrap 16

### Angular v17 Implementation:

Angular v17 is the core framework used to develop the Movie Rating App's front-end. It provides a powerful set of tools and features for building dynamic single-page applications (SPAs) with a rich user interface.

#### Components:

The front-end is organized into several Angular components, each responsible for rendering a specific part of the user interface and encapsulating its behavior. Here's a breakdown of key components and their functionalities:

-   **Home Component:** This component serves as the landing page of the application. It displays a navigation bar and a list of movies available for browsing. Users can click on a movie to view its details and reviews.
-   **Login Component:** Users can log in to their accounts using this component. It provides input fields for username and password, along with validation mechanisms to ensure data integrity.
-   **Movie Page Component:** When users click on a movie from the home page, they are directed to the movie page component. This component renders detailed information about the selected movie, including its title, release year, director, description, and user reviews.
-   **Reviews Component:** This component displays user-generated reviews for a particular movie. It provides a platform for users to share their opinions and ratings, facilitating community interaction and engagement.
-   **Post Review Component:** Users can post their reviews for a movie using this component. It includes input fields for text comments and star ratings, allowing users to express their thoughts and preferences.
-   **Signup Component:** New users can register for an account using this component. It collects necessary information such as username, email, and password, guiding users through the registration process.

#### Register Page
For registering user must go through a set of validators for username, email, password and password confirmation.
![register](https://github.com/Sergiu3107/Movie-Rating/assets/62149434/cd63254c-bd05-49bd-804a-9bd3e269e23f)
#### Login Page
Loging in can be made only if the user has been registered before.
![login](https://github.com/Sergiu3107/Movie-Rating/assets/62149434/dadd45cf-4ac4-4910-995d-df2ce196d859)

#### Movies List Page
Grid of available movies. Can be clicked to follow a certain movie page.
![movie-list](https://github.com/Sergiu3107/Movie-Rating/assets/62149434/956208e4-5948-4768-9a61-e15a72bf0861)

#### Movie Page
Movie page with the movie details and a list of reviews by user. Those can be deleted bt its own user only or by the admin.
![movie-details](https://github.com/Sergiu3107/Movie-Rating/assets/62149434/9f0e8871-4999-4287-87cf-55e405f4eec5)

#### Add Review
User can add a review and rate the movie only if it's logged in.
![post_review](https://github.com/Sergiu3107/Movie-Rating/assets/62149434/db2733ec-b110-45af-a64b-6a5053d6922d)

## Conclusion

The Movie Rating App offers a user-friendly platform for sharing movie reviews and discovering new films based on personal preferences. With robust user management, comprehensive movie catalog, and advanced recommendation system, it aims to enhance the movie-watching experience for users of all backgrounds.
