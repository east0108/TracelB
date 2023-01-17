package SpringSql.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SpringSql.dto.MemberLoginRequest;
import SpringSql.dto.MemberRegisterRequest;
import SpringSql.model.Member;
import SpringSql.service.MemberService;



@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("/members/register")
	public ResponseEntity<Member> register(@RequestBody @Valid MemberRegisterRequest memberRegisterRequest){
		Integer memberId = memberService.register(memberRegisterRequest);
		
		Member member = memberService.getMemberById(memberId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(member);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Member> login(@RequestBody @Valid MemberLoginRequest memberLoginRequest){
		
		
		System.out.println("shfoisjefjioesjif");
		System.out.println("shfoisjefjioesjif");
		System.out.println("shfoisjefjioesjif");
		System.out.println("shfoisjefjioesjif");
		System.out.println("shfoisjefjioesjif");
		
		 Member member = memberService.login(memberLoginRequest);
			
		 
		 return ResponseEntity.status(HttpStatus.OK).body(member);

	}
}
