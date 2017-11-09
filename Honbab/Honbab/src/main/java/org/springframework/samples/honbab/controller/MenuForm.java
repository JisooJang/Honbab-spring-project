package org.springframework.samples.honbab.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.samples.honbab.domain.Menu;


@SuppressWarnings("serial")
public class MenuForm implements Serializable{
	
	private List<Menu> menuList = null;
	
	/*public MenuForm(Menu menu) {
		this.menu = menu;
	}

	public MenuForm() {
		this.menu = new Menu();
	}

	public Menu getRestr() {
		return menu;
	}*/
	
	public List<Menu> getMenuList(){
		return menuList;
	}
	public void setList(List<Menu> menuList){
		this.menuList = menuList;
	}
}
