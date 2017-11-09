package org.springframework.samples.honbab.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.honbab.dao.ReviewDao;
import org.springframework.samples.honbab.dao.mybatis.mapper.ReviewMapper;
import org.springframework.samples.honbab.domain.Review;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisReviewDao implements ReviewDao {
	@Autowired
	private ReviewMapper reviewMapper;

	public List<Review> searchReviewList(int rest_id) 
			throws DataAccessException {
	    return reviewMapper.searchReviewList(rest_id);
	}

	@Override
	public void insertReview(Review review) throws DataAccessException {
	
		reviewMapper.insertReview(review);
	}

	@Override
	public void deleteReview(int review_id) throws DataAccessException {
		reviewMapper.deleteReview(review_id);
		
	}

	@Override
	public int countReview(int rest_id) throws DataAccessException {
		return reviewMapper.countReview(rest_id);
	}

	public int getReviewStar(int review_id) throws DataAccessException {
		return reviewMapper.getReviewStar(review_id);
	}

	@Override
	public String getTotalReviewStar(int rest_id) throws DataAccessException {
		return reviewMapper.getTotalReviewStar(rest_id);
	}

	
	/* Inner Classes */
	/*public static class ProductSearch {

		private List<String> keywordList = new ArrayList<String>();

		public ProductSearch(String keywords) {
			StringTokenizer splitter = new StringTokenizer(keywords," ",false);
			while (splitter.hasMoreTokens()) {
				this.keywordList.add("%" + splitter.nextToken() + "%");
			}
		}
		public List<String> getKeywordList() {
			return keywordList;
		}
	}*/	
}
