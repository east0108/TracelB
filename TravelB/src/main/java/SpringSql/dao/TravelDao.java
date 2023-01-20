package SpringSql.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import SpringSql.dto.TravelQueryParams;
import SpringSql.model.Travel;
import SpringSql.model.jpaTravel;

public interface TravelDao {
		


	List<Travel> getTravelById(String travelQueryParams);

	List<Travel> getTravelAll();
	
	
	
}
