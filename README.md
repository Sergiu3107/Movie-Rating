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

## Database Schema

The application's data structure is organized into three main entities: Users, Movies, and Reviews.

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

## Getting Started

To get started with the Movie Rating App, follow these steps:
1. Clone the repository from GitHub.
2. Install dependencies using your preferred package manager.
3. Set up the database according to the provided schema.
4. Configure environment variables for database connection and other settings.
5. Run the application and start exploring its features.

## Conclusion

The Movie Rating App offers a user-friendly platform for sharing movie reviews and discovering new films based on personal preferences. With robust user management, comprehensive movie catalog, and advanced recommendation system, it aims to enhance the movie-watching experience for users of all backgrounds.
