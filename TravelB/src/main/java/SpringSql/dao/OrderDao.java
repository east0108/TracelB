package SpringSql.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import SpringSql.dto.CreateOrderRequest;
import SpringSql.dto.OrderQueryParams;
import SpringSql.model.Order;
import SpringSql.model.OrderItem;

public interface OrderDao {

		
	Integer createOrder(String Email, Integer totalAmount);

	void createOrderItem(Integer orderId, List<OrderItem> orderItemList);

	Order getOrderById(Integer orderId);

	List<OrderItem> getOrderItemsByOrderId(Integer orderId);

	List<Order> getOrders(OrderQueryParams orderQueryParams);

	Integer countOrder(OrderQueryParams orderQueryParams);

	void delectOrderById(Integer orderId);

	

	
	

	
	
}
