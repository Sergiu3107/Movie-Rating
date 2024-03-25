# Movie Review

### Description

A website where a user can add or delete his review for movies you've watched and also add your rating to it. Users can see each movie average rating and the top 5 reviews of a movie.
You can get movies recommendations based on movies you've rated.
Admin can delete any user review.

### Database Diagram

- **Users :** providing information about a user account. Depending on the user status it can have more functionalities:
    - _regular_ : add/delete its own reviews
    - _admin_   : add/delete anybody's reviews

- **Movies :** movie overview with basic information and average rating
- **Reviews :** comment and rating provided by user on a movie

![Movie_Rating_DB](https://github.com/Sergiu3107/Movie-Rating/assets/62149434/c10995ce-9e8d-4fcb-ad45-df261278bd19)

#### Relationships

- Movies ~ Review ( **one-to-many** ) : Each movie can have multiple reviews.
- User ~ Review ( **one-to-many** ) :  Each user can write multiple reviews.

In this case each review is associated with one movie and one user.

