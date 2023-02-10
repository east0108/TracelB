package SpringSql.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import Spring.constant.TravelCategory;
import SpringSql.dao.TravelDao;
import SpringSql.dto.TravelQueryParams;
import SpringSql.model.Travel;
import SpringSql.model.jpaTravel;
import SpringSql.rowmapper.JpaTravelRowMapper;
import SpringSql.rowmapper.TravelRowMapper;
@Component
public class TravelDaoImpl implements TravelDao {

	@Autowired
	private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;

	@Override
	public List<Travel> getTravelByTown(TravelQueryParams travelQueryParams) {
		
			String sql= "SELECT product_id,name,town,address,tel,tickets,introduce,picture " + " FROM travel2 WHERE 1=1 " ;
			
			Map<String,Object> map=new HashMap<>();
			
			//查詢條件
			if(travelQueryParams.getTown() != null) {
				sql= sql + " AND town = :town";
				map.put("town", travelQueryParams.getTown().name());
				
			}
			
			if(travelQueryParams.getSearch() != null) {
				sql= sql + " AND name LIKE :search";
				map.put("search", "%" + travelQueryParams.getSearch() + "%");
				
			}
			
			//排序
			sql =sql + " ORDER BY " + travelQueryParams.getOrderBy() + " " + travelQueryParams.getSort();
			
			//分頁
			sql =sql + " LIMIT :limit OFFSET :offset";
			map.put("limit", travelQueryParams.getLimit());
			map.put("offset", travelQueryParams.getOffset());
			
			List<Travel> travelList = namedParameterJdbcTemplate.query(sql, map,new TravelRowMapper());
			
			
			if(travelList!=null) {
			
				return  travelList;
			}
				return null;
		
		}

	@Override
	public List<Travel> getTravelAll() {
		
		try {
			String sql= "SELECT product_id,name,town,address,tel,tickets,introduce,picture FROM travel2 ";
			Map<String,Object> map=new HashMap<>();
					
			List<Travel> travelList = namedParameterJdbcTemplate.query(sql, map,new TravelRowMapper());
			
			
				return  travelList;
			
			}catch (Exception e) {
				return null ;
			}
			}
		 

	@Override
	public Travel getTravelById(Integer travelId) {
		
		String sql= "SELECT product_id,name,town,address,tel,tickets,introduce,picture FROM travel2  WHERE product_id  = :travelId";
		Map<String,Object> map=new HashMap<>();
		
		
		map.put("travelId", travelId); 
				
		List<Travel> travelList = namedParameterJdbcTemplate.query(sql, map,new TravelRowMapper());
		
		
		if(travelList.size()>0) {
		
			return  travelList.get(0);
		}
			return null;
	
	}

	
	//取得總比數
	@Override
	public Integer countTravel(TravelQueryParams travelQueryParams) {
		String sql = "SELECT COUNT(*) FROM travel2 WHERE 1=1";
		
		Map<String,Object> map=new HashMap<>();
		//查詢條件
		if(travelQueryParams.getTown() != null) {
			sql= sql + " AND town = :town";
			map.put("town", travelQueryParams.getTown().name());
			
		}
		
		if(travelQueryParams.getSearch() != null) {
			sql= sql + " AND name LIKE :search";
			map.put("search", "%" + travelQueryParams.getSearch() + "%");
			
		}
		
		Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class); 
		
		return total;
	}

	

	}

