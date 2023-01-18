package SpringSql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SpringSql.model.Travel;
import SpringSql.service.TravelService;

@Controller
public class TravelController {
	
	@Autowired
	private  TravelService travelService;
	
	@Autowired
	private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;
	
	
	@GetMapping("/index3")
	public String home () {
	
		
		return "index3";
	}
	
	
	@PostMapping("/index3")
	public String dataPage(Model model,@RequestParam String travelId) {
		
	
	
		List<Travel> travel =travelService.getTravelById(travelId);
			
		
		
		
			model.addAttribute("travel",travel);
			if(travel!=null) {
			return "ok";
		
			}
			model.addAttribute("error","沒有這筆資");
			return "index3";
			
				
	}
	@GetMapping("/login")
	public String Member () {	
		return "login";
	}
	
}