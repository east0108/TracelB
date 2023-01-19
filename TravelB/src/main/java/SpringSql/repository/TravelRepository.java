package SpringSql.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

import SpringSql.model.Travel;
@NoRepositoryBean
public interface TravelRepository extends JpaRepository<Travel, Integer>{

}
