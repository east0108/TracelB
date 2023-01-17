package SpringSql.dao;

import java.util.List;

import SpringSql.model.Travel;

public interface TravelDao {
		


	List<Travel> getTravelById(String travelId);
}
