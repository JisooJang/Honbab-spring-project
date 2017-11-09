package org.springframework.samples.honbab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.honbab.dao.ReservationDao;
import org.springframework.samples.honbab.domain.Reservation;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

	
	@Autowired
	private ReservationDao reservationDao;
	
	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	public ReservationServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<Reservation> get_reservation_list(String user_id) {
		// TODO Auto-generated method stub
		return reservationDao.get_reservation_list(user_id);
	}

	public Reservation get_reservation(int reservation_id) {
		// TODO Auto-generated method stub
		return reservationDao.get_reservation(reservation_id);
	}

	public void insertReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationDao.insertReservation(reservation);
	}

	public void deleteReservation(int reservation_id) {
		// TODO Auto-generated method stub
		reservationDao.deleteReservation(reservation_id);
	}

	@Override
	public void updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationDao.updateReservation(reservation);
		
	}

	public List<Integer> getRest_id_list_in_reservation() {
		return reservationDao.getRest_id_list_in_reservation();
	}
	
	public int get_rest_count(int rest_id) {
		return reservationDao.get_rest_count(rest_id);
	}
}
