package SpringSql.dto;

import javax.validation.constraints.NotNull;

public class DelectItem {
	@NotNull
	private Integer productId;
	


	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}


}
