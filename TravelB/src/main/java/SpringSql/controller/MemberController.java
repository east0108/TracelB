 package SpringSql.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import SpringSql.dto.MemberLoginRequest;
import SpringSql.dto.MemberRegisterRequest;
import SpringSql.model.Member;
import SpringSql.service.MemberService;

@Controller
@CrossOrigin(origins = "*")
public class MemberController {
	final static Logger log = LoggerFactory.getLogger(MemberController.class);
	static List<Member> members = null;
	@Autowired
	private MemberService memberService;

	//登入會員畫面
	@GetMapping("register")
	public String register (@ModelAttribute MemberLoginRequest memberLoginRequest) {	
		return "register";
	}
	
	//新增會員
	@PostMapping("/register")
	public ResponseEntity<Member> register(@RequestBody @Valid MemberRegisterRequest memberRegisterRequest) {

		Integer memberId = memberService.register(memberRegisterRequest);

		Member member = memberService.getMemberById(memberId);

		return ResponseEntity.status(HttpStatus.CREATED).body(member);
	}

	//登入
//	@PostMapping("/login")
//	public ResponseEntity<Member> login(@RequestBody @Valid MemberLoginRequest memberLoginRequest,
//			HttpSession session) {
//
//		Member member = memberService.login(memberLoginRequest);
//
//		session.setAttribute("uid", member.getUserid());
//		session.setAttribute("email", member.getEmail());
//
//		return ResponseEntity.status(HttpStatus.OK).body(member);
//
//	}
	
	//登入註冊畫面
	@GetMapping("/login")
	public String Member (@ModelAttribute MemberLoginRequest memberLoginRequest) {	
		return "login";
	}
	
	//登入會員-thymeleaf
	@PostMapping("/login")
	public String doLogin(
			@ModelAttribute MemberLoginRequest memberLoginRequest, 
			Model model,
			HttpSession session) {
		
		Member member = memberService.login(memberLoginRequest);
		if(member == null) {
			log.warn(memberLoginRequest.getEmail() + "嘗試登入系統");
			return "redirect:login";
		}

		// 設置Session
		session.setAttribute("loginEmail", member.getEmail());
		log.info(memberLoginRequest.getEmail() + "登入系統");
		return "redirect:index";
	}
	
	
	//session登出
	@RequestMapping(value = "/logout", method = {RequestMethod.GET})
	public String logout(HttpSession session, SessionStatus sessionStatus) {
		

		if(session.getAttribute("loginEmail") != null){
			log.info(session.getAttribute("loginEmail").toString() + "登出系統");
			session.removeAttribute("loginEmail");

			sessionStatus.setComplete();
		}
		
		return "redirect:";
	}
	
	
	//檢查郵件
	@PostMapping("/members/checkEmail")
	public ResponseEntity<Member> checkEmail(@RequestBody MemberRegisterRequest memberRegisterRequest) {

		Member member = memberService.getMemberByEmail(memberRegisterRequest);

		return ResponseEntity.status(HttpStatus.OK).body(member);
	}
	
	//登入會員中心畫面
	@GetMapping("/memberCentre")
	public String memberCentre (@ModelAttribute MemberLoginRequest memberLoginRequest) {	
		return "memberCentre";
	}
	
	//更改會員資料
	@PutMapping("/memberCentre")
	public ResponseEntity<Member> updataMember(@RequestBody MemberLoginRequest memberLoginRequest) {
		
		Member member  = memberService.updataMember(memberLoginRequest);
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body(member);
	}
	
}
