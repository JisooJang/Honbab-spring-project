package org.springframework.samples.honbab.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.honbab.domain.Review;

public interface ReviewDao {

	List<Review> searchReviewList(int rest_id) throws DataAccessException;
	
	void insertReview(Review review) throws DataAccessException;
	
	void deleteReview(int review_id) throws DataAccessException;
	
	int countReview(int rest_id) throws DataAccessException;
	
	int getReviewStar(int review_id) throws DataAccessException;
	
	String getTotalReviewStar(int rest_id) throws DataAccessException;
}
