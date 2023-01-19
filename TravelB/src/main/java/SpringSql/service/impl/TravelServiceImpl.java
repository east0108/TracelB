package SpringSql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import SpringSql.dao.TravelDao;
import SpringSql.dto.TravelQueryParams;
import SpringSql.model.Travel;
import SpringSql.repository.TravelRepository;
import SpringSql.service.TravelService;

@Component
public class TravelServiceImpl implements TravelService{
	
	@Autowired
	private TravelDao travelDao;
	
	@Autowired 
	private TravelRepository travelRepository;

	@Override
	public List<Travel> getTravelById(String travelQueryParams) {
		
		return travelDao.getTravelById(travelQueryParams);
	}

	@Override
	public Page<Travel> findpaginated(int pageNO, int pageSize) {
		Pageable pageable =PageRequest.of(pageNO -1, pageSize);
		return travelRepository.findAll(pageable);
	}
	
	
	
	
}
