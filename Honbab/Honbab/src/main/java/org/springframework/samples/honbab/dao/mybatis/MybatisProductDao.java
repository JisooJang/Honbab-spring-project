package org.springframework.samples.honbab.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.honbab.dao.ProductDao;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.samples.honbab.dao.mybatis.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisProductDao implements ProductDao {
	@Autowired
	private ProductMapper productMapper;

	public List<Product> getProductListByCategory(String categoryId, int area, int restrctg) 
			throws DataAccessException {
	    return productMapper.getProductListByCategory(categoryId, area, restrctg);
	}
	
	/*public List<Product> getProductListByCategory(String categoryId) 
			throws DataAccessException {
	    return productMapper.getProductListByCategory(categoryId);
	}*/

	public Product getProduct(String productId) throws DataAccessException {
	    return productMapper.getProduct(productId);
	}

	
	public Product getRestr(int rest_id) throws DataAccessException {
	    return productMapper.getRestr(rest_id);
	}

	public List<Product> searchProductList(String keywords) 
			throws DataAccessException {
	    return productMapper.searchProductList(
	    	"%" + keywords.toLowerCase() + "%");
	}
	@Override
	public void insertRestr(Product restr) throws DataAccessException {
		// TODO Auto-generated method stub
		productMapper.insertRestr(restr);
	}

	@Override
	public void updateRestr(Product restr) throws DataAccessException {
		// TODO Auto-generated method stub
		//return productMapper.updateRestr(restr);
	}
	
	@Override
	public void updateStar(int rest_star, int rest_id) {
		productMapper.updateStar(rest_star, rest_id);
		
	}
	
	@Override
	public List<Product> searchPopularList() throws DataAccessException{
		return productMapper.searchPopularList();
	}
	
	/* Inner Classes */
	public static class ProductSearch {

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
	}
	
	@Override
	public void updateImageOfRestr(Product restr) {
		// TODO Auto-generated method stub
		productMapper.updateImageOfRestr(restr);
	}

}
