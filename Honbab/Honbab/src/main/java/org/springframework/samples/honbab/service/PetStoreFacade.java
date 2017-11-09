package org.springframework.samples.honbab.service;

import java.util.List;

import org.springframework.samples.honbab.domain.Account;
import org.springframework.samples.honbab.domain.Menu;
import org.springframework.samples.honbab.domain.Order;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.samples.honbab.domain.Ranking;
import org.springframework.samples.honbab.domain.Review;


public interface PetStoreFacade {

	Account getAccount(String user_id);

	Account getAccount(String username, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);
	

	void insertRestr(Product restr);
	
	void updateRestr(Product restr);
	
	List<String> getUsernameList();

	List<Product> getProductListByCategory(String categoryId, int area, int restrctg);
	//List<Product> getProductListByCategory(String categoryId);

	List<Product> searchProductList(String keywords);
	
	Product getProduct(String productId);

	Product getRestr(int rest_id);
	
	List<Product> searchPopularList();
	
	List<Review> searchReviewList(int rest_id);
	
	void insertReview(Review review);

	void deleteReview(int review_id);
	
	int countReview(int rest_id);
	
	int getReviewStar(int review_id);
	
	String getTotalReviewStar(int rest_id);
	
	void updateStar(int rest_star, int rest_id);
	
	boolean isItemInStock(String itemId);;


	void insertOrder(Order order);

	Order getOrder(int orderId);

	List<Order> getOrdersByUsername(String username);
	
	void insertMenu(Menu menu);
	
	List<Ranking> getRanking();
	
	void insertImageOfMenu(Menu menu);

	void updateImageOfRestr(Product restr);

	void updateImageOfAccount(Account account);



	List<Menu> getMenuList(int rest_id);

	void updateRestIDOfAccount(int rest_id, String user_id);

	void updateMenu(Menu menu);

}
