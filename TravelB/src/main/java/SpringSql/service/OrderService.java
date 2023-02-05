package SpringSql.service;

import SpringSql.dto.CreateOrderRequest;
import SpringSql.model.Order;

public interface OrderService {

	Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

	Order getOrderById(Integer orderId);
	

}
