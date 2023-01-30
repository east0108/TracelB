package SpringSql.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import SpringSql.model.Travel;
import SpringSql.model.jpaTravel;

public interface TravelRepository extends PagingAndSortingRepository<jpaTravel, Integer>{
	
	 
}
