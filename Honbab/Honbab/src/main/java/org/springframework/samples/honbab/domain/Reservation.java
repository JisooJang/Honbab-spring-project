package org.springframework.samples.honbab.domain;

public class Reservation {

	private int reservation_id;
	private int rest_id;		//?��?�� ?��?��?��
	private int numOfPeople;	//?��?��
	private String visit_date;	//?��?��?���?
	private String visit_time;	//?��?��?���?
	
	private String user_id;	//?��?�� ?��?��?��
	private String name;	//?��?��?�� ?���?
	private String phone;	//?��?��?�� ?��?���?
	private String requested;	// ?���??��?��
	
	private String rest_name;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public int getRest_id() {
		return rest_id;
	}

	public void setRest_id(int rest_id) {
		this.rest_id = rest_id;
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	public String getVisit_date() {
		return visit_date;
	}

	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRequested() {
		return requested;
	}

	public void setRequested(String requested) {
		this.requested = requested;
	}

	public String getVisit_time() {
		return visit_time;
	}

	public void setVisit_time(String visit_time) {
		this.visit_time = visit_time;
	}

	public String getRest_name() {
		return rest_name;
	}

	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}

}
