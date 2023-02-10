package SpringSql.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import SpringSql.dto.TravelQueryParams;
import SpringSql.model.Travel;
import SpringSql.model.jpaTravel;

public interface TravelService {
	
	List<Travel> getTravelByTown(TravelQueryParams travelQueryParams);
	
	List<Travel> getTravelAll();

	Integer countTravel(TravelQueryParams travelQueryParams);


	
//
//	Page<jpaTravel> listAll(int pageNumber);

	}
