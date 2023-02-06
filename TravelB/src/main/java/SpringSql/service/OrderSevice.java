package SpringSql.service;

import SpringSql.dto.CreateOrderRequest;
import SpringSql.model.Order;

public interface OrderSevice {
	
		
	
		String createOrder(String userId,CreateOrderRequest createOrderRequest);

		Order getOrderById(String orderId);
	
}
