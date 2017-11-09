package org.springframework.samples.honbab.service;

import java.util.List;
import java.util.Map;

import org.springframework.samples.honbab.domain.Reservation;


public interface ReservationService {

	public List<Reservation> get_reservation_list(String user_id);	//?��?�� ?��?�� ?��?��?��?�� ?��록된 ?��?�� 리스?���? �??��?��. ?��?�� 리스?���? �??��?��?�� ?��?��id�? (order by)
	
	public Reservation get_reservation(int reservation_id);
	
	public void insertReservation(Reservation reservation);
	
	public void deleteReservation(int reservation_id);
	
	public void updateReservation(Reservation reservation);
	
	public List<Integer> getRest_id_list_in_reservation();
	
	public int get_rest_count(int rest_id);
}
