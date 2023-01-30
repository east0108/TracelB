package SpringSql.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import SpringSql.dto.TravelQueryParams;
import SpringSql.model.Travel;
import SpringSql.model.jpaTravel;

public interface TravelService {
	
	List<Travel> getTravelById(String travelQueryParams);
	
	List<Travel> getTravelAll();




	

	Page<jpaTravel> listAll(int pageNumber);





	
	}
