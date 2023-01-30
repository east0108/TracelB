package SpringSql.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SpringSql.dto.MemberLoginRequest;
import SpringSql.dto.MemberRegisterRequest;
import SpringSql.model.Member;
import SpringSql.service.MemberService;

@RestController
@CrossOrigin(origins = "*")
public class MemberController {
	final static Logger log = LoggerFactory.getLogger(MemberController.class);
	static List<Member> members = null;
	@Autowired
	private MemberService memberService;

	@PostMapping("/members/register")
	public ResponseEntity<Member> register(@RequestBody @Valid MemberRegisterRequest memberRegisterRequest) {

		Integer memberId = memberService.register(memberRegisterRequest);

		Member member = memberService.getMemberById(memberId);

		return ResponseEntity.status(HttpStatus.CREATED).body(member);
	}

	@PostMapping("/login")
	public ResponseEntity<Member> login(@RequestBody @Valid MemberLoginRequest memberLoginRequest,
			HttpSession session) {

		Member member = memberService.login(memberLoginRequest);

		session.setAttribute("uid", member.getUserid());
		session.setAttribute("email", member.getEmail());

		return ResponseEntity.status(HttpStatus.OK).body(member);

	}

	@GetMapping("members/session-username")
	public String getsessionusername(HttpSession session) { // @Path用來取得url路徑的值
		return (String) session.getAttribute("username");
	}

	//用戶登出
	@GetMapping("/sign_out")
	public String signout(HttpSession session) {
		// 銷毀session中的KV
		session.removeAttribute("uid");
		session.removeAttribute("email");
		return "登出成功";
	}
	
	
	//檢查郵件
	@PostMapping("/members/checkEmail")
	public ResponseEntity<Member> checkEmail(@RequestBody MemberRegisterRequest memberRegisterRequest) {

		Member member = memberService.getMemberByEmail(memberRegisterRequest);

		return ResponseEntity.status(HttpStatus.OK).body(member);
	}
}
