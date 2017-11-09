package org.springframework.samples.honbab.dao.mybatis.mapper;

import java.util.List;

import org.springframework.samples.honbab.domain.Reservation;

public interface ReservationMapper {

	public List<Reservation> get_reservation_list(String user_id);

	public List<Reservation> get_reservation_list_by_restaurant(int rest_id);
	
	public Reservation get_reservation(int reservation_id);

	public void insertReservation(Reservation reservation);

	public void deleteReservation(int reservation_id);
	
	public void updateReservation(Reservation reservation);
	
	public List<Integer> getRest_id_list_in_reservation();
	
	public int get_rest_count(int rest_id);


}
