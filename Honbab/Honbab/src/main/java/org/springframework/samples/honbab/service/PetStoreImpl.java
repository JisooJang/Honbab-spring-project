package org.springframework.samples.honbab.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.samples.honbab.dao.AccountDao;
import org.springframework.samples.honbab.dao.MenuDao;
import org.springframework.samples.honbab.dao.ProductDao;
import org.springframework.samples.honbab.dao.RankingDao;
import org.springframework.samples.honbab.dao.ReviewDao;
import org.springframework.samples.honbab.domain.Account;
import org.springframework.samples.honbab.domain.Menu;
import org.springframework.samples.honbab.domain.Order;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.samples.honbab.domain.Ranking;
import org.springframework.samples.honbab.domain.Review;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PetStoreImpl implements PetStoreFacade {

	@Autowired @Qualifier("mybatisRankingDao")
	private RankingDao rankingDao;

	@Autowired   // @Qualifier("mybatisAccountDao")
	private AccountDao accountDao;

	@Autowired
	private MenuDao menuDao;

	@Autowired  @Qualifier("mybatisProductDao")
	private ProductDao productDao;

	@Autowired  @Qualifier("mybatisReviewDao")
	private ReviewDao reviewDao;

	//-------------------------------------------------------------------------
	// Operation methods, implementing the PetStoreFacade interface
	//-------------------------------------------------------------------------

	public Account getAccount(String user_id) {
		return accountDao.getAccount(user_id);
	}

	public Account getAccount(String username, String password) {
		return accountDao.getAccount(username, password);
	}

	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	public List<String> getUsernameList() {
		return accountDao.getUsernameList();
	}


	public List<Product> getProductListByCategory(String categoryId, int area, int restrctg) {
		return productDao.getProductListByCategory(categoryId, area, restrctg);
	}

	/*public List<Product> getProductListByCategory(String categoryId) {
      return productDao.getProductListByCategory(categoryId);
   }*/

	public List<Product> searchProductList(String keywords) {
		return productDao.searchProductList(keywords);
	}

	public Product getProduct(String productId) {
		return productDao.getProduct(productId);
	}

	@Override
	public List<Product> searchPopularList() {

		return productDao.searchPopularList();
	}


	public Product getRestr(int rest_id) {
		return productDao.getRestr(rest_id);
	}


	@Override
	public void insertRestr(Product restr) {
		// TODO Auto-generated method stub
		productDao.insertRestr(restr);
	}

	@Override
	public void updateRestr(Product restr) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean isItemInStock(String itemId) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.insertMenu(menu);
	}



	@Override
	public void insertOrder(org.springframework.samples.honbab.domain.Order order) {
		// TODO Auto-generated method stub

	}


	@Override
	public Order getOrder(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByUsername(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Review> searchReviewList(int rest_id) {
		return reviewDao.searchReviewList(rest_id);
	}

	public void insertReview(Review review) {
		reviewDao.insertReview(review);
	}

	public void deleteReview(int review_id) {
		reviewDao.deleteReview(review_id);
	}

	public int countReview(int rest_id) {
		return reviewDao.countReview(rest_id);
	}

	public int getReviewStar(int review_id) {
		return reviewDao.getReviewStar(review_id);
	}

	public String getTotalReviewStar(int rest_id) {
		return reviewDao.getTotalReviewStar(rest_id);
	}

	public void updateStar(int rest_star, int rest_id) {
		productDao.updateStar(rest_star, rest_id);
	}

	public List<Ranking> getRanking(){
		return rankingDao.getRanking();
	}
	
	@Override
	public void updateImageOfRestr(Product restr) {
		// TODO Auto-generated method stub
		productDao.updateImageOfRestr(restr);
	}

	@Override
	public void updateImageOfAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.updateImageOfAccount(account);
	}


	@Override
	public List<Menu> getMenuList(int rest_id) {
		// TODO Auto-generated method stub
		return menuDao.getMenuList(rest_id);
	}

	@Override
	public void updateRestIDOfAccount(int rest_id, String user_id) {
		// TODO Auto-generated method stub
		accountDao.updateRestIDOfAccount(rest_id, user_id);
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.updateMenu(menu);
	}

	@Override
	public void insertImageOfMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuDao.insertImageOfMenu(menu);
	}



}