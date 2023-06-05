package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.CityService;
import io.HrmsProject.business.requests.cityRequests.CreateCityRequests;
import io.HrmsProject.business.requests.cityRequests.UpdateCityRequests;
import io.HrmsProject.business.responses.cityResponse.GetAllCityResponse;
import io.HrmsProject.business.responses.cityResponse.GetByIdCityResponse;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllCityResponse>> getAll(){
		return cityService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdCityResponse> getById(@RequestParam() int id){
		return cityService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateCityRequests createCity) throws Exception {
		return ResponseEntity.ok(this.cityService.add(createCity));
		
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateCityRequests updateCity) throws Exception {
		this.cityService.update(updateCity);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) {
	 this.cityService.delete(id);
	}
	
}
