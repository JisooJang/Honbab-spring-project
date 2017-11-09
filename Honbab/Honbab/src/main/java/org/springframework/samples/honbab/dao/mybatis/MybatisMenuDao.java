package org.springframework.samples.honbab.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.honbab.dao.MenuDao;
import org.springframework.samples.honbab.dao.mybatis.mapper.MenuMapper;
import org.springframework.samples.honbab.domain.Menu;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisMenuDao implements MenuDao {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public void insertMenu(Menu menu) throws DataAccessException {
		// TODO Auto-generated method stub
		menuMapper.insertMenu(menu);
	}

	@Override
	public void updateMenu(Menu menu) throws DataAccessException {
		// TODO Auto-generated method stub
		menuMapper.updateMenu(menu);
	}


	@Override
	public List<Menu> getMenuList(int rest_id) throws DataAccessException {
		// TODO Auto-generated method stub
		
		return menuMapper.getMenuList(rest_id);
	}

	@Override
	public void insertImageOfMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuMapper.insertImageOfMenu(menu);
	}

	
	

}
