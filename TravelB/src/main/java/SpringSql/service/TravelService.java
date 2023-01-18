package SpringSql.service;

import java.util.List;

import SpringSql.dto.TravelQueryParams;
import SpringSql.model.Travel;

public interface TravelService {
	
	


	List<Travel> getTravelById(String travelQueryParams);
}
