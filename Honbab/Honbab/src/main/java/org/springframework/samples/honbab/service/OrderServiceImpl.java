package org.springframework.samples.honbab.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.honbab.dao.OrderDao;
import org.springframework.samples.honbab.domain.Menu;
import org.springframework.samples.honbab.domain.Order;
import org.springframework.stereotype.Service;
@Service
public class OrderServiceImpl implements OrderService {
 @Autowired
 private OrderDao orderDao;
 
 public List<Menu> getMenuByRestr(int rest_id) {
  return orderDao.getMenuByRestr(rest_id);
 }
 
 public void insertOrder(Order order) {
  orderDao.insertOrder(order);
 }
 
 public Menu getMenu(int menu_id) {
  return orderDao.getMenu(menu_id);
 }
 
 public List<Order> get_ticket_list(String user_id) {
  return orderDao.get_ticket_list(user_id);
 }
 
 public Order getOrder(int ticket_id) {
	 return orderDao.getOrder(ticket_id);
 }
 
 public void cancelOrder(int ticket_id) {
	 orderDao.cancelOrder(ticket_id);
 }
}
 