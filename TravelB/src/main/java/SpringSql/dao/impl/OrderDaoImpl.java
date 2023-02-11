package SpringSql.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import SpringSql.dao.OrderDao;
import SpringSql.dto.CreateOrderRequest;
import SpringSql.dto.OrderQueryParams;
import SpringSql.model.Order;
import SpringSql.model.OrderItem;
import SpringSql.rowmapper.OrderItemRowMapper;
import SpringSql.rowmapper.OrderRowMapper;

@Component
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	@Override
	public Integer createOrder(String Email, Integer totalAmount) {

		String sql = "INSERT INTO `order`(email, total_amount, created_date, last_modified_date)"
				+ "VALUES (:email, :totalAmount, :createdDate, :lastModifiedDate)";

		Map<String, Object> map = new HashMap<>();
		map.put("email", Email);
		map.put("totalAmount", totalAmount);

		Date now = new Date();
		map.put("createdDate", now);
		map.put("lastModifiedDate", now);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

		int orderId = keyHolder.getKey().intValue();
		
		return orderId;

	}

	@Override
	public void createOrderItem(Integer orderId, List<OrderItem> orderItemList) {

		System.out.println("ok2");
		String sql = "INSERT INTO order_item(order_id, product_id,amount)" + "VALUES (:orderId, :productId, :amount)";

		MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[orderItemList.size()];

		for (int i = 0; i < orderItemList.size(); i++) {
			OrderItem orderItem = orderItemList.get(i);

			parameterSources[i] = new MapSqlParameterSource();
			parameterSources[i].addValue("orderId", orderId);
			parameterSources[i].addValue("productId", orderItem.getProductId());
			parameterSources[i].addValue("amount", orderItem.getAmount());

		}

		namedParameterJdbcTemplate.batchUpdate(sql, parameterSources);

	}

	@Override
	public Order getOrderById(Integer orderId) {

		String sql = "SELECT order_id, email, total_amount, created_date, last_modified_date"+
				" FROM `order` WHERE order_id = :orderId";
				
				Map<String,Object> map =new HashMap<>();
				map.put("orderId", orderId);
				System.out.println("ok3"+"  "+orderId);
				
				List<Order> orderList =namedParameterJdbcTemplate.query(sql, map,new OrderRowMapper());
				
				if(orderList.size()>0) {
					
							return orderList.get(0);
				}
					return null;
				
	}

	@Override
	public List<OrderItem> getOrderItemsByOrderId(Integer orderId) {
		String sql ="SELECT oi.order_item_id, oi.order_id,oi.product_id,oi.amount,t.name,t.town,t.address,t.tel,t.tickets,t.introduce,t.picture " +
				" FROM order_item as oi " +
				" LEFT JOIN travel2 as t ON oi.product_id = t.product_id " +
				" WHERE oi.order_id = :orderId ";
	
	Map<String,Object> map =new HashMap<>();
	map.put("orderId", orderId);
	
	List<OrderItem> orderItemList = namedParameterJdbcTemplate.query(sql, map,new OrderItemRowMapper());
	
	
	
	return orderItemList;
	}

	@Override
	public List<Order> getOrders(OrderQueryParams orderQueryParams) {
		
		String sql ="SELECT order_id, email, total_amount,created_date, last_modified_date FROM `order` WHERE 1=1";
		
		Map<String,Object> map =new HashMap<>();
		
		sql=addFilteringSql(sql, map, orderQueryParams);
		
		sql=sql + " ORDER BY created_date DESC";
		
		List<Order> orderList = namedParameterJdbcTemplate.query(sql,map,new OrderRowMapper());
		
		return orderList;
		
		
			}

	@Override
	public Integer countOrder(OrderQueryParams orderQueryParams) {
		
		String sql = "SELECT count(*) FROM `order` WHERE 1=1 ";
		
		Map<String,Object>map =new HashMap<>();
		
		sql = addFilteringSql(sql,map,orderQueryParams);
		
		Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
		
		return total;
	}

	private String addFilteringSql(String sql, Map<String, Object> map, OrderQueryParams orderQueryParams) {
		if(orderQueryParams.getEmail()!=null) {
			sql=sql + " AND email = :email";
			map.put("email",orderQueryParams.getEmail());
			
			
		}
		
		return sql;
	}

	@Override
	public void delectOrderById(Integer orderId) {
		
		String sql ="DELETE o,oi FROM `order` o JOIN order_item oi ON o.order_Id = oi.order_Id WHERE o.order_Id = :orderId";
				
		Map<String,Object> map =new HashMap<>();
		
		map.put("orderId", orderId);
		
		namedParameterJdbcTemplate.update(sql, map);
	}

	




}
