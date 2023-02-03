package SpringSql.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import SpringSql.dao.OrderDao;

public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
}
