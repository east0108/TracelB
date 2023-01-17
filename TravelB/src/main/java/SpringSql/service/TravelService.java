package SpringSql.service;

import java.util.List;

import SpringSql.model.Travel;

public interface TravelService {
	
	
	List<Travel> getTravelById(String travelId);
}
