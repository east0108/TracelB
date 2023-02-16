package SpringSql.dto;

public class OrderQueryParams {
		private String Email;
		private Integer orderId;
		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
}
