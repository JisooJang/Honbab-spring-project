package org.springframework.samples.honbab.dao.mybatis.mapper;

import java.util.List;

import org.springframework.samples.honbab.domain.Menu;

public interface MenuMapper {
	
	void insertMenu(Menu menu);

	void updateMenu(Menu menu);

	List<Menu> getMenuList(int rest_id);
	

	void insertImageOfMenu(Menu menu);

}
