package SpringSql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SpringSql.dao.TravelDao;
import SpringSql.model.Travel;

@Component
public class TravelServiceImpl implements TravelService{
	
	@Autowired
	private TravelDao travelDao;

	@Override
	public Travel getTravelById(Integer travelId) {
		
		return travelDao.getTravelById(travelId);
	}
	
	
	
	
}
