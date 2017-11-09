package org.springframework.samples.honbab.dao.mybatis.mapper;

import java.util.List;
import org.springframework.samples.honbab.domain.Review;

public interface ReviewMapper {

	List<Review> searchReviewList(int rest_id);
	
	void insertReview(Review review);
	
	void deleteReview(int review_id);
	
	int countReview(int rest_id);
	
	int getReviewStar(int review_id);
	
	String getTotalReviewStar(int rest_id);
}
