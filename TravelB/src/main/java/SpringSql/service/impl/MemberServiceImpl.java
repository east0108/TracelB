package SpringSql.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import SpringSql.dao.MemberDao;
import SpringSql.dto.MemberCheckEmail;
import SpringSql.dto.MemberLoginRequest;
import SpringSql.dto.MemberRegisterRequest;
import SpringSql.model.Member;
import SpringSql.service.MemberService;



@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	
	private final static Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	public MemberServiceImpl(MemberDao memberRepository) {
		this.memberDao = memberRepository;
	}

	
	
	@Override
	public Member getMemberById(Integer memberId) {
		
		return memberDao.getMemberById(memberId);
	}


	@Override
	public Integer register(MemberRegisterRequest memberRegisterRequest) {
		Member member = memberDao.getMemberByEmail(memberRegisterRequest.getEmail());
		
		if(member != null) {
			log.warn("該 email {} 已經被註冊",memberRegisterRequest.getEmail());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return memberDao.createMember(memberRegisterRequest);
	}



	@Override
	public Member login(MemberLoginRequest memberLoginRequest) {
		Member member = memberDao.getMemberByEmail(memberLoginRequest.getEmail());
		
		if(member == null) {
			log.warn("該 email {} 尚未註冊",memberLoginRequest.getEmail());
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			return null;
		}
		if(member.getPassword().equals(memberLoginRequest.getPassword())) {
			return member;
		}else {			
			log.warn("該 email {} 的密碼不正確",memberLoginRequest.getEmail());
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			return null;
			
		}
		
	}



	@Override
	public Member getMemberByEmail(MemberRegisterRequest memberRegisterRequest) {
		Member member = memberDao.getMemberByEmail(memberRegisterRequest.getEmail());
		
	
		if(member != null) {
			log.warn("該 email {} 已經被註冊",memberRegisterRequest.getEmail());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		log.warn("該 email {} 尚未註冊",memberRegisterRequest.getEmail());
		return memberDao.getMemberByEmail(memberRegisterRequest.getEmail());
	}



	@Override
	public Member updataMember(MemberLoginRequest memberLoginRequest) {
		
		memberDao.updataMember(memberLoginRequest);
		Member member = memberDao.getMemberByEmail(memberLoginRequest.getEmail());
		if(member != null) {
			log.warn("該 email {} 更新成功	",memberLoginRequest.getEmail());
		}
		return member;
	}

}
