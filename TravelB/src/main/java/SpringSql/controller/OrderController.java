package SpringSql.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SpringSql.dto.CreateOrderRequest;
import SpringSql.model.Order;
import SpringSql.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//創建清單	  //userId=使用者帳號
	@PostMapping("/users/{userId}/orders")
	public ResponseEntity<?> createOrder(@PathVariable Integer userId,
										 @RequestBody @Valid CreateOrderRequest createOrderRequest){
	//資料庫中插入數據
	Integer	orderId = orderService.createOrder(userId,createOrderRequest);
	
	//整筆訂單資訊
	Order order = orderService.getOrderById(orderId);
	

	
	
	 
	return ResponseEntity.status(HttpStatus.CREATED).body(order);
	
	
	}
}
