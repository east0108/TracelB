package SpringSql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import SpringSql.dto.CreateOrderRequest;
import SpringSql.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//創建清單					//userId=使用者帳號
	@PostMapping("/users/{userId}/orders")
	public ResponseEntity<?> createOrder(@PathVariable Integer userId,
										 @RequestBody CreateOrderRequest createOrderRequest){
	Integer	orderId = orderService.createOrder(userId,createOrderRequest);
	 
	return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
	
	
	}
}
