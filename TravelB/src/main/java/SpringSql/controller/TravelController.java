package SpringSql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SpringSql.model.Travel;
import SpringSql.service.TravelService;

@Component
public class TravelController {
	
	@Autowired
	private  TravelService travelService;
	
	
	public Travel getTravel(Integer travelId) {
		Travel travel = travelService.getTravelById(travelId);
		
		return travel;
	}
}
