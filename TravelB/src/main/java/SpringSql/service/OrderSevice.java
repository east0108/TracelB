package SpringSql.service;

import java.util.List;

import SpringSql.dto.CreateOrderRequest;
import SpringSql.dto.OrderQueryParams;
import SpringSql.model.Order;

public interface OrderSevice {
	
		
	
		Integer createOrder(String Email,CreateOrderRequest createOrderRequest);

		Order getOrderById(Integer orderId);

		List<Order> getOrders(OrderQueryParams orderQueryParams);

		Integer countOrder(OrderQueryParams orderQueryParams);

		void deleteOrderById(Integer orderId);


	

		

	
	
}
