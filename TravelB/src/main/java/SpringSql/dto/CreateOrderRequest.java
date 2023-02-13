package SpringSql.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class CreateOrderRequest {

	@NotEmpty
	private List<BuyItem> buyItemList;
	private List<DelectItem> delectItemList;

	public List<BuyItem> getBuyItemList() {
		return buyItemList;
	}

	public void setBuyItemList(List<BuyItem> buyItemList) {
		this.buyItemList = buyItemList;
	}

	public List<DelectItem> getDelectItemList() {
		return delectItemList;
	}

	public void setDelectItemList(List<DelectItem> delectItemList) {
		this.delectItemList = delectItemList;
	}


	
	
}
