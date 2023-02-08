package SpringSql.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Spring.constant.TravelCategory;
import SpringSql.dto.TravelQueryParams;
import SpringSql.model.Travel;
import SpringSql.service.TravelService;

@Controller
public class TravelController {

	@Autowired
	private TravelService travelService;

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
	public ResponseEntity<List<Travel>> getProducts(
			// 查詢條件Filtering
			@RequestParam(required = false) TravelCategory town, @RequestParam(required = false) String search,

			// 排序sorting
			@RequestParam(defaultValue = "product_id") String orderBy,
			@RequestParam(defaultValue = "asc") String sort) {
		TravelQueryParams travelQueryParams = new TravelQueryParams();

		travelQueryParams.setTown(town);
		travelQueryParams.setSearch(search);
		travelQueryParams.setOrderBy(orderBy);
		travelQueryParams.setSort(sort);

		// 取得 product list
		List<Travel> travelList = travelService.getTravelByTown(travelQueryParams);

		return ResponseEntity.status(HttpStatus.OK).body(travelList);
	}

}
