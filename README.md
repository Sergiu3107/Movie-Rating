# Movie Review

### Description
____

A website where a user can add or delete his review for movies you've watched and also add your rating to it. Users can see each movie average rating and the top 5 reviews of a movie.
You can get movies recommendations based on movies you've rated.
Admin can delete any user review.

### Database Diagram
____

- **Users :** providing information about a user account. Depending on the user status it can have more functionalities:
    - _regular_ : add/delete its own reviews
    - _admin_   : add/delete anybody's reviews

- **Movies :** movie overview with basic information and average rating
- **Reviews :** comment and rating provided by user on a movie

![Movie_Rating_DB](https://github.com/Sergiu3107/Movie-Rating/assets/62149434/c10995ce-9e8d-4fcb-ad45-df261278bd19)

### Relationships
____

- Movies ~ Review ( **one-to-many** ) : Each movie can have multiple reviews.
- User ~ Review ( **one-to-many** ) :  Each user can write multiple reviews.

In this case each review is associated with one movie and one user.

### Endpoints
____

#### Movie: 

- **GET** : /movie/show/all - Retrieve all movies available in the system.
- **GET** : /movie/show/{id} - Retrieve details of a specific movie identified by its ID.
- **DELETE** : /movie/remove/{id} - Delete a movie from the system based on its ID.
- **POST** : /movie/add - Add a new movie to the system.
- **PUT** : /movie/update/{id} - Update details of an existing movie identified by its ID.

#### Review:

- **GET** : /review/show/all - Retrieve all reviews available in the system.
- **GET** : /review/show/{id} - Retrieve details of a specific review identified by its ID.
- **DELETE** : /review/remove/{id} - Delete a review from the system based on its ID.
- **POST** : /review/add - Add a new review to the system.
- **PUT** : /review/update/{id} - Update details of an existing review identified by its ID.
- **PUT** : /review/like/{id} - Increment the number of likes for a specific review identified by its ID.

#### User:

- **GET** : /user/show/all - Retrieve all users registered in the system.
- **GET** : /user/show/{id} - Retrieve details of a specific user identified by its ID.
- **DELETE** : /user/remove/{id} - Delete a user from the system based on its ID.
- **POST** : /user/add - Register a new user in the system.
- **PUT** : /user/update/{id} - Update details of an existing user identified by its ID.
