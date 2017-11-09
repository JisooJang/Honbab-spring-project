package org.springframework.samples.honbab.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {

	/* Private Fields */
	private int rest_id;
	private String rest_name;
	private String rest_addr;
	private String rest_phone;
	private String rest_time;
	private int rest_seat;
	private int rest_reser_count;
	private String rest_thumbnail;
	private int rest_account;
	private int rest_bankcode;
	private int rest_star;
	private int rest_ctg;

	private int reservation_count;


	public String toString() {
		return getRest_name();
	}

	public Product(int rest_id) {
		super();
		this.rest_id = rest_id;
	}

	public Product() {
		super();
	}

	public int getRest_id() {
		return rest_id;
	}

	public void setRest_id(int rest_id) {
		this.rest_id = rest_id;
	}

	public String getRest_name() {
		return rest_name;
	}

	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}

	public String getRest_addr() {
		return rest_addr;
	}

	public void setRest_addr(String rest_addr) {
		this.rest_addr = rest_addr;
	}

	public String getRest_phone() {
		return rest_phone;
	}

	public void setRest_phone(String rest_phone) {
		this.rest_phone = rest_phone;
	}

	public String getRest_time() {
		return rest_time;
	}

	public void setRest_time(String rest_time) {
		this.rest_time = rest_time;
	}

	public int getRest_seat() {
		return rest_seat;
	}

	public void setRest_seat(int rest_seat) {
		this.rest_seat = rest_seat;
	}

	public int getRest_reser_count() {
		return rest_reser_count;
	}

	public void setRest_reser_count(int rest_reser_count) {
		this.rest_reser_count = rest_reser_count;
	}

	public String getRest_thumbnail() {
		return rest_thumbnail;
	}

	public void setRest_thumbnail(String rest_thumbnail) {
		this.rest_thumbnail = rest_thumbnail;
	}

	public int getRest_account() {
		return rest_account;
	}

	public void setRest_account(int rest_account) {
		this.rest_account = rest_account;
	}

	public int getRest_bankcode() {
		return rest_bankcode;
	}

	public void setRest_bankcode(int rest_bankcode) {
		this.rest_bankcode = rest_bankcode;
	}

	public int getRest_star() {
		return rest_star;
	}

	public void setRest_star(int rest_star) {
		this.rest_star = rest_star;
	}

	public int getRest_ctg() {
		return rest_ctg;
	}

	public void setRest_ctg(int rest_ctg) {
		this.rest_ctg = rest_ctg;
	}

	public int getReservation_count() {
		return reservation_count;
	}

	public void setReservation_count(int reservation_count) {
		this.reservation_count = reservation_count;
	}



}
