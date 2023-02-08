package SpringSql.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping("/users/{Email}/orders")
	public ResponseEntity<?> createOrder(@PathVariable String Email,
										 @RequestBody @Valid CreateOrderRequest createOrderRequest){
			System.out.println("傳入值"+createOrderRequest);
			String userEmail= orderSevice.createOrder(Email,createOrderRequest);
			Order order = orderSevice.getOrderById(userEmail);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
	
	@GetMapping("/user/{Email}/orderitem")
	public ResponseEntity<Order> selectOrder(@PathVariable String Email){
		
			
			Order order = orderSevice.getOrderById(Email);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(order);
	

}
}