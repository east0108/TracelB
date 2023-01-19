package SpringSql.service;

import java.util.List;

import org.springframework.data.domain.Page;

import SpringSql.dto.TravelQueryParams;
import SpringSql.model.Travel;

public interface TravelService {
	
	List<Travel> getTravelById(String travelQueryParams);
	Page<Travel> findpaginated(int pageNO,int pageSize);
	
	}
