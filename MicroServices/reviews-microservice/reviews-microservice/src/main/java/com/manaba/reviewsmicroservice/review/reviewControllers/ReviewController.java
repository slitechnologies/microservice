package com.manaba.reviewsmicroservice.review.reviewControllers;

import com.manaba.reviewsmicroservice.review.reviewEntities.Review;
import com.manaba.reviewsmicroservice.review.reviewServices.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;


    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
        boolean isReviewPresent = reviewService.addReview(companyId, review);
        if (isReviewPresent)
            return new ResponseEntity<>("Review created Successfully", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Review is No present in the system!", HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }


    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(
            @PathVariable Long reviewId) {
        if (reviewId != null)
            return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(
            @PathVariable Long reviewId,
            @RequestBody Review updatedReview) {
        boolean isReviewUpdated = reviewService.updateReview(reviewId, updatedReview);
        if (isReviewUpdated)
            return new ResponseEntity<>("Review Successfully Updated", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Review Update Failed", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(
            @PathVariable Long reviewId) {
        boolean isReviewDeleted = reviewService.deleteReview(reviewId);
        if (isReviewDeleted) {
            return new ResponseEntity<>("Review Successfully Deleted !", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Deletion Failed", HttpStatus.NOT_FOUND);
        }
    }
}
