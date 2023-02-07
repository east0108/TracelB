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
import SpringSql.service.OrderSevice;

@Component
public class OrderServiceImpl implements OrderSevice{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private TravelDao travelDao;
	
	
	
	
	
	
	@Override
	public Order getOrderById(String orderId) {
		
		Order order =orderDao.getOrderById(orderId);
		
		List<OrderItem> orderItemList= orderDao.getOrderItemsByOrderId(orderId);
		
		order.setOrderItemList(orderItemList);
		
		return order;
	}






	@Transactional
	@Override
	public String createOrder(String userId, CreateOrderRequest createOrderRequest) {
		
		int Amount = 0;
		int totalAmount=0;
		List<OrderItem> orderItemList =new ArrayList<>();
		
		for(BuyItem buyItem : createOrderRequest.getBuyItemList()) {
			Travel travel = travelDao.getTravelById(buyItem.getProductId());
			
			totalAmount =travel.getTicket();
			Amount +=travel.getTicket();
		
			OrderItem orderItem =new OrderItem();
			
			orderItem.setProductId(buyItem.getProductId());
			orderItem.setAmount(totalAmount);
			
			orderItemList.add(orderItem);
			
		}
		
		//創建訂單
		String orderId=orderDao.createOrder(userId,Amount);
		
		orderDao.createOrderItem(orderId,orderItemList);
		
		return orderId;
	}

}
