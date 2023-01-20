package SpringSql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SpringSql.model.Travel;
import SpringSql.model.jpaTravel;
import SpringSql.repository.TravelRepository;
import SpringSql.service.TravelService;

@Controller
public class TravelController {
	
	@Autowired
	private  TravelService travelService;
	


	@GetMapping("/index")
	public String home () {
		return "index";
	}
	

	@GetMapping("/login")
	public String Member () {	
		return "login";
	}
//	
//	@GetMapping("/find")
//	public String viewHomePage(Model model) {		
//		List<Travel> travel = travelService.getTravelAll();
//		model.addAttribute("travel",travel);
//		return "Find";
//	}
//	
	
	@RequestMapping("/find")
	
	public String viewHomePAGE(Model model) {
		return listByPage(model, 1);
	}
	
	@GetMapping("/find/{pageNumber}")
	public String listByPage(Model model,@PathVariable("pageNumber")int currentPage) {
			
		Page<jpaTravel>  page =travelService.listAll(currentPage);
		long totalItems =page.getTotalElements();
		int totalPages =page.getTotalPages();
	
		List<jpaTravel> listTravels =page.getContent(); 
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("listTravel",listTravels);
		return "Find";
	}
	
	
	@PostMapping("/find")
	public String dataPage(Model model,@RequestParam String travelId) {
		
		List<Travel> travel =travelService.getTravelById(travelId);		
		
			model.addAttribute("travel",travel);
			if(travel!=null) {
			return "ok";
		
			}
			model.addAttribute("error","沒有這筆資料");
			return "index";
			
				
	}
	
	

	


	
}