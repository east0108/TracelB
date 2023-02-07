package SpringSql.model;

import java.util.Date;
import java.util.List;

public class Order {
	
	private Integer orderId;
	private String email;
	private Integer totalAmount;
	private Date  createdDate;
	private Date  lastModifieDate;
	
	private List<OrderItem> orderItemList;
	
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifieDate() {
		return lastModifieDate;
	}
	public void setLastModifieDate(Date lastModifieDate) {
		this.lastModifieDate = lastModifieDate;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	
}
