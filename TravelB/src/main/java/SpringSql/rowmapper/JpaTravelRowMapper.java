package SpringSql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import SpringSql.model.Travel;
import SpringSql.model.jpaTravel;

public class JpaTravelRowMapper implements RowMapper<jpaTravel> {

	@Override
	public jpaTravel mapRow(ResultSet rs, int rowNum) throws SQLException {
			 
		jpaTravel travel =new jpaTravel();
			
			travel.setId(rs.getInt("id"));
			travel.setName(rs.getString("name"));
			travel.setTown(rs.getString("town"));
			travel.setAddress(rs.getString("address"));
			travel.setTel(rs.getString("tel"));
			travel.setTicket(rs.getString("tickets"));
			travel.setIntroduce(rs.getString("introduce"));
			travel.setPicture(rs.getString("picture"));
		
			
			return travel ;
	}



}
