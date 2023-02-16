package SpringSql.service.impl;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

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
			
			Amount =buyItem.getQuantity()*travel.getTicket();
			totalAmount += Amount;
		
			OrderItem orderItem =new OrderItem();
			
			orderItem.setProductId(buyItem.getProductId());
			orderItem.setQuantity(buyItem.getQuantity());
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



	@Override
	public String getPay(OrderQueryParams orderQueryParams) throws UnsupportedEncodingException {
		AllInOne allInOne = new AllInOne("");
		AioCheckOutALL aioCheckOutALL =new AioCheckOutALL();
//		Integer intPayOderId = Integer.parseInt(payOrderId);
		Order pay = orderDao.getOrderById(orderQueryParams.getOrderId());



		String orderId =  Integer.toString(pay.getOrderId()) ;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String orderDate = dateFormat.format(pay.getCreatedDate());

		String orderTotal = Integer.toString(pay.getTotalAmount());





		aioCheckOutALL.setMerchantTradeNo("3002607"+orderId);
		aioCheckOutALL.setMerchantTradeDate("2023/02/15 16:22:30");
		aioCheckOutALL.setPeriodType("aio");
		aioCheckOutALL.setTotalAmount(orderTotal);
		aioCheckOutALL.setTradeDesc("123");
		aioCheckOutALL.setItemName("商店名稱");
		aioCheckOutALL.setReturnURL("https://www.google.com.tw/");
		aioCheckOutALL.setChooseSubPayment("ALL");
		aioCheckOutALL.setPeriodType("");
		aioCheckOutALL.setClientBackURL("http://localhost:8080/travel/CIC");

		String payOrder = allInOne.aioCheckOut(aioCheckOutALL,null);




		return payOrder ;
	}

}
















