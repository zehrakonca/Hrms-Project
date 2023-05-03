package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.EducationTypeService;
import io.HrmsProject.business.requests.educationTypeRequests.CreateEducationTypeRequests;
import io.HrmsProject.business.requests.educationTypeRequests.UpdateEducationTypeRequests;
import io.HrmsProject.business.responses.educationTypeResponses.GetAllEducationTypeResponses;
import io.HrmsProject.business.responses.educationTypeResponses.GetByEducationTypeIdResponses;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/educationTypes")
public class EducationTypesController {
	
	private EducationTypeService educationTypeService;
	
	@Autowired
	public EducationTypesController(EducationTypeService educationTypeService) {
		super();
		this.educationTypeService = educationTypeService;
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateEducationTypeRequests educationType) throws Exception{
		return ResponseEntity.ok(this.educationTypeService.add(educationType));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateEducationTypeRequests educationType)throws Exception{
		return ResponseEntity.ok(this.educationTypeService.update(educationType));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllEducationTypeResponses>> getAll(){
		return this.educationTypeService.getAll();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id){
		return ResponseEntity.ok(this.educationTypeService.delete(id));
	}
	
	@GetMapping("/getById")
	public DataResult<GetByEducationTypeIdResponses> getById(@RequestParam() int id){
		return this.educationTypeService.getById(id); 
	}
	
}
