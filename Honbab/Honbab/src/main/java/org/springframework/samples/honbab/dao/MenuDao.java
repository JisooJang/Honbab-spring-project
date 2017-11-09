package org.springframework.samples.honbab.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.honbab.domain.Menu;


public interface MenuDao {
	
	void insertMenu(Menu menu) throws DataAccessException;

	void updateMenu(Menu menu) throws DataAccessException;

	List<Menu> getMenuList(int rest_id) throws DataAccessException;
	
	void insertImageOfMenu(Menu menu);
}
