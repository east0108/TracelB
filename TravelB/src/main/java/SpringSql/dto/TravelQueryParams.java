package SpringSql.dto;

import Spring.constant.TravelCategory;

public class TravelQueryParams {
	
	private TravelCategory town;
	private String search;
	private String orderBy;
	private String sort;
	
	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public TravelCategory getTown() {
		return town;
	}

	public void setTown(TravelCategory town) {
		this.town = town;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	private String travel;
	
	
	public String getTravel() {
		return travel;
	}

	public void setTravel(String travel) {
		this.travel = travel;
	}

	private Integer limit;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
}
