package SpringSql.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import ecpay.payment.integration.AllInOneBase;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import SpringSql.dto.CreateOrderRequest;
import SpringSql.dto.OrderQueryParams;

import SpringSql.model.Order;
import SpringSql.model.Page;
import SpringSql.service.OrderSevice;

@Controller
public class OrderController {

	@Autowired
	private OrderSevice orderSevice;
	
	//創建訂單
	@PostMapping("/user/{Email}/orderitem")
	public ResponseEntity<?> createOrder(@PathVariable String Email,
			@RequestBody @Valid CreateOrderRequest createOrderRequest) {

		Integer orderId = orderSevice.createOrder(Email, createOrderRequest);
		Order order = orderSevice.getOrderById(orderId);

		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
	//查詢訂單
	@GetMapping("/users/{Email}/orders")
	public ResponseEntity<Page<Order>> getOrder(@PathVariable String Email) {
		OrderQueryParams orderQueryParams = new OrderQueryParams();
		orderQueryParams.setEmail(Email);

		List<Order> orderList = orderSevice.getOrders(orderQueryParams);
		Integer count = orderSevice.countOrder(orderQueryParams);

		Page<Order> page = new Page<>();

		page.setTotal(count);
		page.setResults(orderList);

		return ResponseEntity.status(HttpStatus.CREATED).body(page);

	}
	
	@DeleteMapping("/user/{orderId}/delectOrder")
	public ResponseEntity<?> deleteOrder(@PathVariable Integer orderId){
		orderSevice.deleteOrderById(orderId);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PostMapping("/pay")
	public ResponseEntity<?> pay(@RequestBody Integer orderId) throws UnsupportedEncodingException {
		String payOrderId = orderSevice.getPay(orderId);

		return ResponseEntity.status(HttpStatus.OK).body(payOrderId);
	}
}