package org.springframework.samples.honbab.controller;

import org.springframework.samples.honbab.domain.Reservation;

public class ReservationCommand {

	private Reservation reservation;	// domain 객체 ?��?��
	
	public ReservationCommand() {
		this.reservation = new Reservation();
	}
	
	public ReservationCommand(Reservation reservation) {
		this.reservation = reservation;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
