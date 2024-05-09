package com.proj.movie_rating;

import com.proj.movie_rating.model.Review;
import com.proj.movie_rating.repository.ReviewRepository;
import com.proj.movie_rating.service.ReviewService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReviewTest {

    @Mock
    private ReviewRepository reviewRepoMock;

    @InjectMocks
    private ReviewService reviewService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllReviewsTest() {
        // Mocking ReviewRepository's behavior
        List<Review> reviews = Arrays.asList(
                new Review(1, null, null, 4.5f, "nice", 20),
                new Review(2, null, null, 4.0f, "eh eh nice", 15),
                new Review(3, null, null, 5.0f, "best", 34)
        );
        when(reviewRepoMock.findAll()).thenReturn(reviews);

        // Calling the service method
        List<Review> reviewList = reviewService.getAllReviews();

        // Verifying if the method was called and returned the correct value
        assertEquals(reviews.size(), reviewList.size());
        assertTrue(reviewList.containsAll(reviews));
    }

    @Test
    public void getReviewTest() {
        // Mocking ReviewRepository's behavior
        Review review = new Review(1, null, null, 4.5f, "nice", 20);
        when(reviewRepoMock.findById(1)).thenReturn(Optional.of(review));

        // Calling the service method
        Review returnedReview = reviewService.getReview(1);

        // Verifying if the method was called and returned the correct value
        assertNotNull(returnedReview);
        assertEquals(review, returnedReview);
    }

    @Test
    public void deleteAReviewTest() {
        // Mocking ReviewRepository's behavior
        when(reviewRepoMock.existsById(1)).thenReturn(true);

        // Calling the service method
        boolean result = reviewService.deleteAReview(1);

        // Verifying if the method was called and returned the correct value
        assertTrue(result);
        verify(reviewRepoMock).deleteById(1);
    }

    @Test
    public void postReviewTest() {
        // Creating a review
        Review review = new Review(null, null, 4.5f, "nice", 20);

        // Calling the service method
        reviewService.postReview(review);

        // Verifying if the save method of ReviewRepository is called once
        verify(reviewRepoMock, times(1)).save(review);
    }

    @Test
    public void putReviewTest() {
        // Mocking ReviewRepository's behavior
        Review review = new Review(1, null, null, 4.5f, "nice", 20);
        when(reviewRepoMock.existsById(1)).thenReturn(true);
        when(reviewRepoMock.findById(1)).thenReturn(Optional.of(review));

        // Updating review details
        Review updatedReview = new Review(null, null, 4.0f, "updated review", 30);

        // Calling the service method
        boolean result = reviewService.putReview(1, updatedReview);

        // Verifying if the method was called and returned the correct value
        assertTrue(result);
        verify(reviewRepoMock).save(review);
        assertEquals(updatedReview.getRating(), review.getRating(), 0.001);
        assertEquals(updatedReview.getReview(), review.getReview());
    }
}
