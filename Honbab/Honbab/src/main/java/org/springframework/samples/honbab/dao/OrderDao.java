package org.springframework.samples.honbab.dao;
import java.util.List;
import org.springframework.samples.honbab.domain.Menu;
import org.springframework.samples.honbab.domain.Order;
public interface OrderDao {
  
  List<Menu> getMenuByRestr(int rest_id);
  
  void insertOrder(Order order);
  
  Menu getMenu(int menu_id);
  
  List<Order> get_ticket_list(String user_id);
  
  public Order getOrder(int ticket_id);
  
  public void cancelOrder(int ticket_id);

}
 