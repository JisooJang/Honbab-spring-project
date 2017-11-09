package org.springframework.samples.honbab.dao.mybatis;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.honbab.dao.OrderDao;
import org.springframework.samples.honbab.dao.mybatis.mapper.OrderMapper;
import org.springframework.samples.honbab.domain.Menu;
import org.springframework.samples.honbab.domain.Order;
import org.springframework.stereotype.Repository;
@Repository
public class MybatisOrderDao implements OrderDao {
 
 @Autowired
 private OrderMapper orderMapper;

 @Override
 public List<Menu> getMenuByRestr(int rest_id) {
  return orderMapper.getMenuByRestr(rest_id);
 }
 @Override
 public void insertOrder(Order order) {
  orderMapper.insertOrder(order);
 }
 
 @Override
 public Menu getMenu(int menu_id) {
  return orderMapper.getMenu(menu_id);
 }
 
 @Override
 public List<Order> get_ticket_list(String user_id){
  return orderMapper.get_ticket_list(user_id);
 }
 
 @Override
 public Order getOrder(int ticket_id) {
	 return orderMapper.getOrder(ticket_id);
 }
 
 @Override
 public void cancelOrder(int ticket_id) {
	 orderMapper.cancelOrder(ticket_id);
 }
 
}
 