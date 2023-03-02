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

import io.HrmsProject.business.abstracts.JobExperienceService;
import io.HrmsProject.business.requests.jobExperienceRequests.CreateJobExperienceRequests;
import io.HrmsProject.business.requests.jobExperienceRequests.UpdateJobExperienceRequests;
import io.HrmsProject.business.responses.jobExperienceResponses.GetAllJobExperienceResponses;
import io.HrmsProject.business.responses.jobExperienceResponses.GetByIdJobExperienceResponse;
import io.HrmsProject.business.responses.jobExperienceResponses.GetByJobSeekerIdResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateJobExperienceRequests createJobExperienceRequests) throws Exception{
		return ResponseEntity.ok(this.jobExperienceService.add(createJobExperienceRequests));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateJobExperienceRequests updateJobExperienceRequests)throws Exception{
		return ResponseEntity.ok(this.jobExperienceService.update(updateJobExperienceRequests));
	}
	
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return this.jobExperienceService.delete(id);
	}
	
	@GetMapping("/getAllBySortedEndDate")
	public DataResult<GetByJobSeekerIdResponse> getAllBySortedEndDate(@RequestParam int jobSeekerId) {
		return jobExperienceService.getAllBySortedEndDate(jobSeekerId);
	}
	
	@GetMapping("/getAllJobExperienceDetail")
	public DataResult<List<GetAllJobExperienceResponses>> getAll(){
		return jobExperienceService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdJobExperienceResponse getById(@PathVariable int id){
		return jobExperienceService.getById(id);
	}

	@GetMapping("/{id}")
	public DataResult<GetByJobSeekerIdResponse> getByJobSeekerId(@PathVariable int jobSeekerId){
		return jobExperienceService.getByJobSeekerIdResponse(jobSeekerId);
	}
}