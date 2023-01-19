package SpringSql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/ok")
	public String viewHomePage(Model model) {
	return	findPaginated(1, model);
	}
	
	@GetMapping("/ok/{pageNo}")
	public String findPaginated(@PathVariable (value="pageNo")int pageNo,Model model) {
		int pageSize = 5;
		Page<Travel> page =travelService.findpaginated(pageNo, pageSize);
		List<Travel> listEmployees =page.getContent();
		
		model.addAttribute("currentPage",pageNo);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		model.addAttribute("listEmployees",listEmployees);
		
		return "ok" ;
	}
	
}