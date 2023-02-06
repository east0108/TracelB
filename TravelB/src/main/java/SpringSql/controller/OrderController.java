package SpringSql.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import SpringSql.dto.CreateOrderRequest;
import SpringSql.model.Order;
import SpringSql.service.OrderSevice;

@Controller
public class OrderController {
	
	@Autowired
	private OrderSevice orderSevice;
	
	@PostMapping("/users/{userId}/orders")
	public ResponseEntity<?> createOrder(@PathVariable String userId,
										 @RequestBody @Valid CreateOrderRequest createOrderRequest){
			System.out.println("傳入值"+createOrderRequest);
			String orderId= orderSevice.createOrder(userId,createOrderRequest);
			
			Order order = orderSevice.getOrderById(orderId);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
}
