package SpringSql.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SpringSql.dao.OrderDao;
import SpringSql.dao.TravelDao;
import SpringSql.dto.BuyItem;
import SpringSql.dto.CreateOrderRequest;
import SpringSql.model.Order;
import SpringSql.model.OrderItem;
import SpringSql.model.Travel;
import SpringSql.service.OrderService;


@Component
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private TravelDao travelDao;
	
	
	@Override
	public Order getOrderById(Integer orderId) {
		Order order = orderDao.getOrderById(orderId);
		
		List<OrderItem> orderItemsList = orderDao.getOrderItemsByOrderId(orderId);
		
		order.setOrderItemList(orderItemsList);
		
		return order;
	}
	
	@Transactional
	@Override
	public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) { 
		
		
		
		int totalAmount=0;
		
		List<OrderItem> orderItemList =new ArrayList<>();
		
		for(BuyItem buyItem : createOrderRequest.getBuyItemList()) {
			Travel travel = travelDao.getTravelById(buyItem.getProductId());
			
		//計算總價錢
		int amount =buyItem.getQuantity() * travel.getTicket(); 
		totalAmount = totalAmount + amount;
		
		
		// 轉換 buyItem to OrderItem
		OrderItem orderItem =new OrderItem();
		orderItem.setProductId(buyItem.getProductId());
		orderItem.setQuantity(buyItem.getQuantity());
		orderItem.setAmount(amount);
		
		orderItemList.add(orderItem);
		
		}
		
		//創建清單
		Integer orderId = orderDao.createOrder(userId,totalAmount);
								//讓orderItemList對應到orderId的訂單上面
		orderDao.createOrderItems(orderId, orderItemList);
		
		return orderId;
	}








}
