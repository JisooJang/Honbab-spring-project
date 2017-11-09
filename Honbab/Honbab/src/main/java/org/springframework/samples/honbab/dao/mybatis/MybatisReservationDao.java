package org.springframework.samples.honbab.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.honbab.dao.ReservationDao;
import org.springframework.samples.honbab.dao.mybatis.mapper.ReservationMapper;
import org.springframework.samples.honbab.domain.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisReservationDao implements ReservationDao {

	@Autowired
	private ReservationMapper reservationMapper;
	
	public void setReservationMapper(ReservationMapper reservationMapper) {
		this.reservationMapper = reservationMapper;
	}

	public MybatisReservationDao() {
		// TODO Auto-generated constructor stub
	}

	public List<Reservation> get_reservation_list(String user_id) {
		// TODO Auto-generated method stub
		return reservationMapper.get_reservation_list(user_id);
	}

	public Reservation get_reservation(int reservation_id) {
		// TODO Auto-generated method stub
		return reservationMapper.get_reservation(reservation_id);
	}

	public void insertReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationMapper.insertReservation(reservation);
	}

	public void deleteReservation(int reservation_id) {
		// TODO Auto-generated method stub
		reservationMapper.deleteReservation(reservation_id);
	}
	
	public void updateReservation(Reservation reservation) {
		reservationMapper.updateReservation(reservation);
	}
	
	public List<Integer> getRest_id_list_in_reservation() {
		return reservationMapper.getRest_id_list_in_reservation();
	}
	
	public int get_rest_count(int rest_id) {
		return reservationMapper.get_rest_count(rest_id);
	}
}
