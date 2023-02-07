package SpringSql.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import SpringSql.model.Order;
import SpringSql.model.OrderItem;

public interface OrderDao {

		
	String createOrder(String userId, Integer totalAmount);

	void createOrderItem(String orderId, List<OrderItem> orderItemList);

	Order getOrderById(String orderId);

	List<OrderItem> getOrderItemsByOrderId(String orderId);
	
	
	
	
}
