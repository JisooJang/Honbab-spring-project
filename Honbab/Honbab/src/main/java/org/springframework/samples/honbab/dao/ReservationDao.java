package org.springframework.samples.honbab.dao;

import java.util.List;

import org.springframework.samples.honbab.domain.Reservation;

public interface ReservationDao {
	public List<Reservation> get_reservation_list(String user_id);	//?��?�� ?��?�� ?��?��?��?�� ?��록된 ?��?�� 리스?���? �??��?��. ?��?�� 리스?���? �??��?��?�� ?��?��id�? (order by)
	
	public Reservation get_reservation(int reservation_id);
	
	public void insertReservation(Reservation reservation);
	
	public void deleteReservation(int reservation_id);
	
	public void updateReservation(Reservation reservation);
	
	public List<Integer> getRest_id_list_in_reservation();
	
	public int get_rest_count(int rest_id);
}
