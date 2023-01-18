package SpringSql.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import SpringSql.dto.MemberLoginRequest;
import SpringSql.dto.MemberRegisterRequest;
import SpringSql.model.Member;
import SpringSql.service.MemberService;



@RestController
public class MemberController {
	final static Logger log = LoggerFactory.getLogger(MemberController.class);
	static List<Member> members = null;
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/members/register")
	public ResponseEntity<Member> register(@RequestBody @Valid MemberRegisterRequest memberRegisterRequest){
		
		System.out.println("shfoisjefjioesjif");
		System.out.println("shfoisjefjioesjif");
		System.out.println("shfoisjefjioesjif");
		System.out.println("shfoisjefjioesjif");
		System.out.println("shfoisjefjioesjif");
		
		Integer memberId = memberService.register(memberRegisterRequest);
		
		Member member = memberService.getMemberById(memberId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(member);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Member> login(@RequestBody @Valid MemberLoginRequest memberLoginRequest,Model model){
		
		
		
		
		 Member member = memberService.login(memberLoginRequest);
			
		 model.addAttribute("member",member);
		 return ResponseEntity.status(HttpStatus.OK).body(member);

	}
}
