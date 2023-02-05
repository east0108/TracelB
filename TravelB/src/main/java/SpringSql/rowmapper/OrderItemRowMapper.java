package SpringSql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import SpringSql.model.OrderItem;

public class OrderItemRowMapper implements RowMapper<OrderItem>{

	@Override
	public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderItem orderItem =new OrderItem();
		orderItem.setOrderItemId(rs.getInt("order_item_id"));
		orderItem.setOrderId(rs.getInt("order_id"));
		orderItem.setProductId(rs.getInt("product_id"));
		orderItem.setQuantity(rs.getInt("quantity"));
		orderItem.setAmount(rs.getInt("amount"));
		
	
		orderItem.setName(rs.getString("name"));
		orderItem.setTown(rs.getString("town"));
		orderItem.setAddress(rs.getString("address"));
		orderItem.setTel(rs.getString("tel"));
		orderItem.setTickets(rs.getInt("tickets"));
		orderItem.setIntroduce(rs.getString("introduce"));
		orderItem.setPicture(rs.getString("picture"));
		
		
		return orderItem;
	}
	

}
