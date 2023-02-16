package SpringSql.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import SpringSql.dto.CreateOrderRequest;
import SpringSql.dto.OrderQueryParams;
import SpringSql.model.Order;

public interface OrderSevice {
	
		
	
		Integer createOrder(String Email,CreateOrderRequest createOrderRequest);

		Order getOrderById(Integer orderId);

		List<Order> getOrders(OrderQueryParams orderQueryParams);

		Integer countOrder(OrderQueryParams orderQueryParams);

<<<<<<< HEAD

=======
		String getPay(OrderQueryParams orderQueryParams) throws UnsupportedEncodingException;
>>>>>>> branch 'main' of https://github.com/a92075123/TravelB.git

		void deleteOrderById(Integer orderId);


	

		

	
	
}
