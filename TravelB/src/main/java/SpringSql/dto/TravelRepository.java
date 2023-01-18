package SpringSql.dto;

import org.springframework.data.repository.PagingAndSortingRepository;

import SpringSql.model.Travel;

public interface TravelRepository extends PagingAndSortingRepository<Travel, Long>{
		
}
