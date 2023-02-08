package SpringSql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import Spring.constant.TravelCategory;
import SpringSql.model.Travel;

public class TravelRowMapper implements RowMapper<Travel> {

	@Override
	public Travel mapRow(ResultSet rs, int rowNum) throws SQLException {
			 
			Travel travel =new Travel();
			
			travel.setId(rs.getInt("product_id"));
			travel.setName(rs.getString("name"));
			
			String townStr=rs.getString("town");
			TravelCategory town = TravelCategory.valueOf(townStr);
			travel.setTown(town);
			
			
			
			travel.setAddress(rs.getString("address"));
			travel.setTel(rs.getString("tel"));
			travel.setTicket(rs.getInt("tickets"));
			travel.setIntroduce(rs.getString("introduce"));
			travel.setPicture(rs.getString("picture"));
		
			
			return travel ;
	}



}
