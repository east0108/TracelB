package SpringSql.dao;

import java.util.List;

import SpringSql.model.Order;
import SpringSql.model.OrderItem;

public interface OrderDao {

	Integer createOrder(Integer userId, int totalAmount);

	void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

	Order getOrderById(Integer orderId);

	List<OrderItem> getOrderItemsByOrderId(Integer orderId); 

}
