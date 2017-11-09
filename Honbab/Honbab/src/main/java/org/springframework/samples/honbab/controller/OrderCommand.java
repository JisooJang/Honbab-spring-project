package org.springframework.samples.honbab.controller;

import org.springframework.samples.honbab.domain.Order;

public class OrderCommand {
	
	private Order order;

	public OrderCommand(Order order) {
		this.order = order;
	}
	
	public OrderCommand() {
		this.order = new Order();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	

}
