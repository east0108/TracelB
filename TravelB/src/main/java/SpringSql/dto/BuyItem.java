package SpringSql.dto;

import javax.validation.constraints.NotNull;



public class BuyItem {
	
	@NotNull
	private Integer travelId;
	
	@NotNull
	private Integer quInteger;
	
	public Integer gettravelId() {
		return travelId;
	}


	public void settravelId(Integer travelId) {
		this.travelId = travelId;
	}


	public Integer getQuInteger() {
		return quInteger;
	}


	public void setQuInteger(Integer quInteger) {
		this.quInteger = quInteger;
	}




	
	
	
}
