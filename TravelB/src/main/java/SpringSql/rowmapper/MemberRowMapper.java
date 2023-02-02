package SpringSql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import SpringSql.model.Member;



public class MemberRowMapper  implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Member member = new Member();
		member.setUserid(rs.getInt("user_id"));
		member.setEmail(rs.getString("email"));
		member.setName(rs.getString("name"));
		member.setGender(rs.getString("gender"));
		member.setPassword(rs.getString("password"));
		member.setPhone(rs.getString("phone"));
		member.setAddress(rs.getString("address"));
		member.setCity(rs.getString("city"));
		member.setBirthday(rs.getDate("birthday"));
		member.setCreateddate(rs.getDate("created_date"));
		
		return member;
	}
	
	

}
