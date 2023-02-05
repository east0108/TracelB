package SpringSql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SpringSql.dao.OrderDao;
import SpringSql.dao.TravelDao;
import SpringSql.dto.BuyItem;
import SpringSql.dto.CreateOrderRequest;
import SpringSql.model.Travel;
import SpringSql.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private TravelDao travelDao;

	@Override
	public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
		
		int totalAmount=0;
		
		for(BuyItem buyItem : createOrderRequest.getBuyItemList()) {
			Travel travel = travelDao.getTravelById(buyItem.gettravelId());
			
		//計算總價錢
		int amount =buyItem.getQuInteger() * travel.getTicket(); 
		totalAmount = totalAmount + amount;
		}
		
		//創建清單
		Integer orderId = orderDao.createOrder();
		
		orderDao.createOrderItem();
		
		return orderId;
	}
}
