package SpringSql.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import SpringSql.dao.MemberDao;
import SpringSql.dto.MemberLoginRequest;
import SpringSql.dto.MemberRegisterRequest;
import SpringSql.model.Member;
import SpringSql.rowmapper.MemberRowMapper;

@Component
public class MemberDaoImpl implements MemberDao {

	// @PersistenceContext 會對每一個客戶端的請求配置一個專用的EntityManager物件
	@PersistenceContext
	EntityManager em;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Member getMemberById(Integer memberId) {
		String sql = "SELECT user_id, email, name, gender, password, phone, address, city, birthday, created_date "
				+ "FROM member WHERE user_id = :memberId ";

		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);

		List<Member> memberList = namedParameterJdbcTemplate.query(sql, map, new MemberRowMapper());

		if (memberList.size() > 0) {
			return memberList.get(0);
		} else {

			return null;
		}
	}

	@Override
	public Member getMemberByEmail(String email) {
		String sql = "SELECT user_id, email, name, gender, password, phone, address, city, birthday, created_date "
				+ "FROM member WHERE email = :email ";

		Map<String, Object> map = new HashMap<>();
		map.put("email", email);

		List<Member> memberList = namedParameterJdbcTemplate.query(sql, map, new MemberRowMapper());

		if (memberList.size() > 0) {
			return memberList.get(0);
		} else {

			return null;
		}
	}

	@Override
	public Integer createMember(MemberRegisterRequest memberRegisterRequest) {
		String sql = "INSERT INTO member(email,password,created_date) " + "VALUES(:email, :password, :createddate)";

		Map<String, Object> map = new HashMap<>();
		map.put("email", memberRegisterRequest.getEmail());
		map.put("password", memberRegisterRequest.getPassword());

		java.util.Date now = new java.util.Date();
		map.put("createddate", now);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

		int memberId = keyHolder.getKey().intValue();

		return memberId;
	}

	@Override
	public Integer updataMember(MemberLoginRequest memberLoginRequest) {
		String sql = "UPDATE member SET name = :name, gender = :gender, phone = :phone, "
				   + "address = :address, city = :city, birthday = :birthday " 
				   + "WHERE email = :email ";

//		Map<String, Object> map = new HashMap<>();
//		map.put("email", memberRegisterRequest.getEmail());
//		map.put("name", memberRegisterRequest.getName());
//		map.put("gender", memberRegisterRequest.getGender());
//		map.put("phone", memberRegisterRequest.getPhone());
//		map.put("address", memberRegisterRequest.getAddress());
//		map.put("city", memberRegisterRequest.getCity());
//		map.put("birthday", memberRegisterRequest.getBirthday());

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(memberLoginRequest); 
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		
		return namedParameterJdbcTemplate.update(sql, paramSource,keyHolder) ;
	}

}
