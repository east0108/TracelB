package SpringSql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SpringSql.model.Travel;
import SpringSql.service.TravelService;

@Component
public class TravelController {
	
	@Autowired
	private  TravelService travelService;
	
	
	public List<Travel> getTravel(String travelId) {
		List<Travel> travel = travelService.getTravelById(travelId);
		
		return travel;
	}
}
