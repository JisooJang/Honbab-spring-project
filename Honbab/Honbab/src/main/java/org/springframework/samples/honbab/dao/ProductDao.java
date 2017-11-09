package org.springframework.samples.honbab.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.honbab.domain.Product;

public interface ProductDao {

	List<Product> getProductListByCategory(String categoryId, int area, int restrctg) throws DataAccessException;
	//List<Product> getProductListByCategory(String categoryId) throws DataAccessException;

	List<Product> searchProductList(String keywords) throws DataAccessException;

	Product getProduct(String productId) throws DataAccessException;
	
	Product getRestr(int rest_id) throws DataAccessException;

	 void insertRestr(Product restr) throws DataAccessException;

	 void updateRestr(Product restr) throws DataAccessException;
	 
	 void updateStar(int rest_star, int rest_id) throws DataAccessException;
	 
	 List<Product> searchPopularList() throws DataAccessException;
	 void updateImageOfRestr(Product restr);
}
