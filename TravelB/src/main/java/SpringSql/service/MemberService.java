package SpringSql.service;

import org.springframework.stereotype.Service;

import SpringSql.dto.MemberLoginRequest;
import SpringSql.dto.MemberRegisterRequest;
import SpringSql.model.Member;


@Service
public interface MemberService {

	Member getMemberById(Integer memberId);
	
	Member getMemberByEmail(MemberRegisterRequest memberRegisterRequest);
	
	Integer register(MemberRegisterRequest memberRegisterRequest);
	
	Member login(MemberLoginRequest memberLoginRequest);
	
	Member updataMember(MemberLoginRequest memberLoginRequest);
	
//	void save(Member member);
//	List<Me mber> findAll();
//	Member findById(Integer id);
//	Member findByMemberId(String memberId);
//	void deleteById(Integer id);
//	Member update(Member member);
//	void detach(Member member);	
}