package SpringSql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import SpringSql.model.Travel;

public class TravelRowMapper implements RowMapper<Travel> {

	@Override
	public Travel mapRow(ResultSet rs, int rowNum) throws SQLException {
			 
			Travel travel =new Travel();
			
			travel.setId(rs.getInt("id"));
			travel.setName(rs.getString("name"));
			travel.setTown(rs.getString("town"));
			travel.setAddress(rs.getString("address"));
			travel.setTel(rs.getString("tel"));
			travel.setTicket(rs.getInt("tickets"));
			travel.setIntroduce(rs.getString("introduce"));
			travel.setPicture(rs.getString("picture"));
		
			
			return travel ;
	}



}
