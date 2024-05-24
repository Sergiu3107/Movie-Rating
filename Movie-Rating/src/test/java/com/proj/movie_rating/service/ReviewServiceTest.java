package com.proj.movie_rating.service;

import com.proj.movie_rating.model.Review;
import com.proj.movie_rating.repository.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReviewServiceTest {

    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepoMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reviewService = new ReviewService(reviewRepoMock);
    }

    @Test
    public void getReviewTest() {

        Review review = new Review(1, null, null, 4.5f, "nice", 20);
        when(reviewRepoMock.findById(1)).thenReturn(Optional.of(review));

        Review result = reviewService.getReview(1);

        assertEquals(result, review);
        verify(reviewRepoMock).findById(1);
    }

    @Test
    public void getAllReviewsTest() {

        List<Review> reviews = Arrays.asList(
                new Review(1, null, null, 4.5f, "nice", 20),
                new Review(2, null, null, 4.0f, "eh eh nice", 15),
                new Review(3, null, null, 5.0f, "best", 34)
        );

        when(reviewRepoMock.findAll()).thenReturn(reviews);

        List<Review> result = reviewService.getAllReviews();

        assertEquals(result.size(), reviews.size());
        verify(reviewRepoMock).findAll();
    }

    @Test
    public void deleteAReviewTest() {

        when(reviewRepoMock.existsById(1)).thenReturn(true);

        boolean result = reviewService.deleteAReview(1);

        assertTrue(result);
        verify(reviewRepoMock).deleteById(1);
    }

    @Test
    public void postReviewTest() {

        Review reviewTest = new Review(null, null, 4.5f, "nice", 20);

        when(reviewRepoMock.save(reviewTest)).thenReturn(reviewTest);

        reviewService.postReview(reviewTest);
        verify(reviewRepoMock).save(reviewTest);
    }

    @Test
    public void putReviewTest() {

        Review review = new Review(1, null, null, 4.5f, "nice", 20);

        when(reviewRepoMock.existsById(1)).thenReturn(true);
        when(reviewRepoMock.findById(1)).thenReturn(Optional.of(review));

        Review updatedReview = new Review(null, null, 4.0f, "updated review", 30);
        boolean result = reviewService.putReview(1, updatedReview);

        assertTrue(result);
        verify(reviewRepoMock).save(review);
    }

    @Test
    public void updateReviewTest() {

        Review updatedReview = new Review(null, null, 4.0f, "updated review", 30);
        reviewService.putReview(1, updatedReview);

        Review review = reviewService.getReview(1);

        assertEquals(review.getReview(), updatedReview.getReview());
    }

    @Test
    public void updateRatingTest() {

        Review updatedReview = new Review(null, null, 4.0f, "updated review", 30);
        reviewService.putReview(1, updatedReview);

        Review review = reviewService.getReview(1);

        assertEquals(review.getRating(), updatedReview.getRating());
    }
}
