package SpringSql.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import SpringSql.dao.OrderDao;

@Component
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

}
