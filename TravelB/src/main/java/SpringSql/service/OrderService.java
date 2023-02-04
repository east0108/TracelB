package SpringSql.service;

import SpringSql.dto.CreateOrderRequest;

public interface OrderService {

	Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
	

}
