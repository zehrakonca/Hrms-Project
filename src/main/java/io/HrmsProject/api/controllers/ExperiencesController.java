package io.HrmsProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import io.HrmsProject.business.abstracts.ExperienceService;
import io.HrmsProject.business.requests.experienceRequests.CreateExperienceRequest;
import io.HrmsProject.business.requests.experienceRequests.UpdateExperienceRequest;
import io.HrmsProject.business.responses.experienceResponses.GetAllExperienceResponse;
import io.HrmsProject.business.responses.experienceResponses.GetByIdExperienceResponse;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin
public class ExperiencesController {
	
	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllExperienceResponse>> getAll(){
		return experienceService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdExperienceResponse> getById(@RequestParam() int id){
		return experienceService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid CreateExperienceRequest createExperience) throws Exception {
		this.experienceService.add(createExperience);
		
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateExperienceRequest updateExperience) throws Exception {
		this.experienceService.update(updateExperience);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) {
	 this.experienceService.delete(id);
	}

}
