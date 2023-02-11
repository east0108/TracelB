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
import SpringSql.dto.DelectItem;
import SpringSql.dto.OrderQueryParams;
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
	public Order getOrderById(Integer orderId) {
		
		Order order =orderDao.getOrderById(orderId);
		
		List<OrderItem> orderItemList= orderDao.getOrderItemsByOrderId(orderId);
		
		order.setOrderItemList(orderItemList);
		
		return order;
	}






	@Transactional
	@Override
	public Integer createOrder(String Email, CreateOrderRequest createOrderRequest) {
		
		int Amount = 0;
		int totalAmount=0;
		List<OrderItem> orderItemList =new ArrayList<>();
		
		for(BuyItem buyItem : createOrderRequest.getBuyItemList()) {
			Travel travel = travelDao.getTravelById(buyItem.getProductId());
			
			Amount =travel.getTicket();
			totalAmount +=travel.getTicket();
		
			OrderItem orderItem =new OrderItem();
			
			orderItem.setProductId(buyItem.getProductId());
			orderItem.setAmount(Amount);
			
			orderItemList.add(orderItem);
			
		}
		
		//創建訂單
		Integer orderId=orderDao.createOrder(Email,totalAmount);
		
		orderDao.createOrderItem(orderId,orderItemList);
		
		return orderId;
	}






	@Override
	public List<Order> getOrders(OrderQueryParams orderQueryParams) {
		List<Order> orderList=orderDao.getOrders(orderQueryParams);
		
		for(Order order : orderList) {
			List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(order.getOrderId());
			
			order.setOrderItemList(orderItemList);
		}
		
		return orderList;
	}






	@Override
	public Integer countOrder(OrderQueryParams orderQueryParams) {
		
		return orderDao.countOrder(orderQueryParams);
	}






	@Override
	public void deleteOrderById(Integer orderId) {
		orderDao.delectOrderById(orderId);
		
	}











	}
















