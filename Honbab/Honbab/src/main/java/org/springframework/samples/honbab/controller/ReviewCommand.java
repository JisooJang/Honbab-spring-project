package org.springframework.samples.honbab.controller;

import java.io.Serializable;

import org.springframework.samples.honbab.domain.Review;

@SuppressWarnings("serial")
public class ReviewCommand implements Serializable {

   private Review review;

   private boolean newReview;


   public ReviewCommand(Review review) {
      this.review = review;
      this.newReview = false;
   }

   public ReviewCommand() {
      this.review = new Review();
      this.newReview = true;
   }

   public Review getReview() {
      return review;
   }

   public boolean isNewReview() {
      return newReview;
   }

}