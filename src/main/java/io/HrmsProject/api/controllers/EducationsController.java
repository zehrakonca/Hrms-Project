package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.EducationService;
import io.HrmsProject.business.requests.educationRequests.CreateEducationRequests;
import io.HrmsProject.business.requests.educationRequests.UpdateEducationRequests;
import io.HrmsProject.business.responses.educationResponses.GetAllEducationResponses;
import io.HrmsProject.business.responses.educationResponses.GetByIdEducationResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {
	
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping
	public DataResult<List<GetAllEducationResponses>> getAll(){
		return educationService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Education> getById(@PathVariable int id){
		return educationService.getById(id);
	}
	
	@GetMapping("/{id}")
	public DataResult<GetByIdEducationResponse> getByIdDetail(@PathVariable int id){
		return educationService.getByEducationId(id);
		}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateEducationRequests createEducationRequests) throws Exception{
		return ResponseEntity.ok(this.educationService.add(createEducationRequests));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateEducationRequests updateEducationRequests){
		return ResponseEntity.ok(this.educationService.update(updateEducationRequests));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@PathVariable int id) {
		return this.educationService.delete(id);
	}
	
	@GetMapping("/getAllBySortedGraduationDate")
	public DataResult<List<Education>> getAllBySortedGraduationDate(@RequestParam int jobSeekerId) {
		return educationService.getAllBySortedGraduationDate(jobSeekerId);
	}

	
	
	

}
