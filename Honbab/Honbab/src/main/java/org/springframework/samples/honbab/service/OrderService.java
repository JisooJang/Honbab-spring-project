package org.springframework.samples.honbab.service;
import java.util.List;
import org.springframework.samples.honbab.domain.Menu;
import org.springframework.samples.honbab.domain.Order;

public interface OrderService {
 
 public List<Menu> getMenuByRestr(int rest_id);
 
 public void insertOrder(Order order);
 
 public Menu getMenu(int menu_id);
 
 public List<Order> get_ticket_list(String user_id);
 
 public Order getOrder(int ticket_id);
 
 public void cancelOrder(int ticket_id);
 
}
 