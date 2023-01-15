package SpringSql.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import SpringSql.model.Travel;

 

@Controller
public class JspController {
	
	@Autowired
	private  TravelController travelController;
	

	
	
	@GetMapping("/home")
	public String home () {
	
		
		return "index";
	}
	
	
	@PostMapping("/home")
	public String dataPage(Model model,@RequestParam Integer travelId) {
		
	
	
		Travel travel =travelController.getTravel(travelId);
		
		
		
		
			model.addAttribute("travel",travel);
			if(travel!=null) {
			return "ok";
		
			}
			model.addAttribute("error","沒有這筆資料");
			return "index";
			
				
	}
}
	
	

	
	
	
