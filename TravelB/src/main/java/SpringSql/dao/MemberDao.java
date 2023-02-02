package SpringSql.dao;

import java.util.List;

import SpringSql.dto.MemberLoginRequest;
import SpringSql.dto.MemberRegisterRequest;
import SpringSql.model.Member;



public interface MemberDao {
	
	Member getMemberById(Integer memberId);
	
	Member getMemberByEmail(String email);

	Integer createMember(MemberRegisterRequest memberRegisterRequest);
	
	Integer updataMember(MemberLoginRequest memberLoginRequest);
	
//	void save(Member member);
//	List<Member> findAll();
//	Member findById(Integer id);
//	Member findByMemberId(String memberId);
//	void deleteById(Integer id);
//	Member update(Member member);
//	void detach(Member member);
}
