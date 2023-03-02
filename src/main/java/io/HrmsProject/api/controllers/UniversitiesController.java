package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.UniversityService;
import io.HrmsProject.business.requests.universityRequests.CreateUniversityRequest;
import io.HrmsProject.business.requests.universityRequests.UpdateUniversityRequest;
import io.HrmsProject.business.responses.universityResponse.GetAllUniversityResponse;
import io.HrmsProject.business.responses.universityResponse.GetByIdUniversityResponse;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/universities")
public class UniversitiesController {
	
	private UniversityService universityService;
	
	@Autowired
	public UniversitiesController(UniversityService universityService) {
		super();
		this.universityService = universityService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() CreateUniversityRequest university) throws Exception{
		return ResponseEntity.ok(this.universityService.add(university));
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody() UpdateUniversityRequest university)throws Exception{
		return ResponseEntity.ok(this.universityService.update(university));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return ResponseEntity.ok(this.universityService.delete(id));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllUniversityResponse>> getAll(){
		return this.universityService.getAll();
	}
	
	@GetMapping("/getById")
	public GetByIdUniversityResponse getById(@PathVariable int id){
		return this.universityService.getById(id);
	}

}
