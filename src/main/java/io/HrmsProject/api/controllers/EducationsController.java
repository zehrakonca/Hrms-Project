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

import io.HrmsProject.business.abstracts.EducationService;
import io.HrmsProject.business.requests.educationRequests.CreateEducationRequests;
import io.HrmsProject.business.requests.educationRequests.UpdateEducationRequests;
import io.HrmsProject.business.responses.educationResponses.GetAllEducationResponses;
import io.HrmsProject.business.responses.educationResponses.GetByIdEducationResponse;
import io.HrmsProject.business.responses.educationResponses.GetByJobSeekerEducationResponses;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {
	
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllEducationResponses>> getAll(){
		return educationService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdEducationResponse> getById(@RequestParam() int id){
		return educationService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateEducationRequests createEducationRequests) throws Exception{
		return ResponseEntity.ok(this.educationService.add(createEducationRequests));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateEducationRequests updateEducationRequests)throws Exception{
		return ResponseEntity.ok(this.educationService.update(updateEducationRequests));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.educationService.delete(id);
	}
	
	@GetMapping("/getAllBySortedGraduationDate")
	public DataResult<List<GetByJobSeekerEducationResponses>> getAllBySortedGraduationDate(@RequestParam int jobSeekerId) {
		return educationService.getByJobSeekerIdSorted(jobSeekerId);
	}

	
	
	

}
