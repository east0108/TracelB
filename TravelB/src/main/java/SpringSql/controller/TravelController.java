package SpringSql.controller;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Spring.constant.TravelCategory;
import SpringSql.dto.TravelQueryParams;
import SpringSql.model.Travel;
import SpringSql.service.TravelService;
@Validated
@Controller
public class TravelController {

	@Autowired
	private TravelService travelService;
	
	@GetMapping("/NO")
	public String error() {
		return "NO";
	}
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}


	@GetMapping("/find")
	public String traveldata() {
		return "Find";
	}

	@GetMapping("/CIC")
	public String products() {

		return "CIC";

		}
		
	


			
		@GetMapping("/products")
	    public ResponseEntity<SpringSql.util.Page<Travel>> getProducts(
	            //查詢條件Filtering
	           @RequestParam (required = false) TravelCategory town,
	           @RequestParam (required = false) String search,

	           //排序sorting
	           @RequestParam (defaultValue = "product_id") String orderBy,
	           @RequestParam (defaultValue = "asc") String sort,	
	           @RequestParam (defaultValue = "6") @Max(1000)@Min(0) Integer limit,
	           @RequestParam (defaultValue = "0") @Min(0)Integer offset
	    )
		{
	        TravelQueryParams travelQueryParams = new TravelQueryParams();

	        travelQueryParams.setTown(town);
	        travelQueryParams.setSearch(search);
	        travelQueryParams.setOrderBy(orderBy);
	        travelQueryParams.setSort(sort);	        
	        travelQueryParams.setLimit(limit);	        
	        travelQueryParams.setOffset(offset);	        


	        //取得 product list
	        List<Travel> travelList = travelService.getTravelByTown(travelQueryParams);
	     
	        //取得 product 總數
	        Integer total = travelService.countTravel(travelQueryParams);
	        
	        //分頁
	        SpringSql.util.Page<Travel> page = new SpringSql.util.Page<>();
	        page.setLimit(limit);
	        page.setOffset(offset);
	        page.setTotal(total);
	        page.setResult(travelList);
	        
	        return ResponseEntity.status(HttpStatus.OK).body(page);
	    }	

					
				

	}
		
