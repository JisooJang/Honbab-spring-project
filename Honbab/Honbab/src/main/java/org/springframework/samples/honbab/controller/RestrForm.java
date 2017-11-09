package org.springframework.samples.honbab.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.samples.honbab.domain.Menu;
import org.springframework.samples.honbab.domain.Product;
import org.springframework.web.multipart.MultipartFile;



@SuppressWarnings("serial")
public class RestrForm implements Serializable {

	private Product restr;
	private List<Menu> menuList = null;
	private MultipartFile thumbnail;
	private List<MultipartFile> menufiles;
	private boolean newRestr;


	public RestrForm(Product restr, List<Menu> menuList) {
		this.restr = restr;
		this.menuList = menuList;
		this.newRestr = false;
	}

	public RestrForm() {
		this.restr = new Product();
		this.menuList = new ArrayList<Menu>();
		this.menufiles = new ArrayList<MultipartFile>();
		this.newRestr = true;
		thumbnail = null;
	}



	public Product getRestr() {
		return restr;
	}

	public boolean isNewRestr() {
		return newRestr;
	}
	public List<Menu> getMenuList(){
		return menuList;
	}
	public void setList(List<Menu> menuList){
		this.menuList = menuList;
	}
	public MultipartFile getThumnail() {
		return thumbnail;
	}

	public void setThumnail(MultipartFile thumnail) {
		this.thumbnail = thumnail;
	}
	public List<MultipartFile> getMenufiles() {
		return menufiles;
	}

	public void setMenufiles(List<MultipartFile> menufiles) {
		this.menufiles = menufiles;
	}

	public void setMenuList(List<Menu> menuList) {
		// TODO Auto-generated method stub
		this.menuList = menuList;
	}

}
