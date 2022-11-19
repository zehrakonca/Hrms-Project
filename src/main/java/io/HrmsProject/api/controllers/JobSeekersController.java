package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.JobSeekerService;
import io.HrmsProject.business.requests.jobSeekerRequests.CreateJobSeekerRequests;
import io.HrmsProject.business.requests.jobSeekerRequests.UpdateJobSeekerRequest;
import io.HrmsProject.business.responses.jobSeekerResponses.GetAllJobSeekerResponses;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllJobSeekerResponses>> getAll(){
		return jobSeekerService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobSeeker> getById(int id){
		return this.jobSeekerService.getById(id);
	}
	
	@GetMapping("/getByNationalityId")
	public DataResult<JobSeeker> getByNationalityId(String nationalIdentity){
		return this.jobSeekerService.getByIdentityNumber(nationalIdentity);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() CreateJobSeekerRequests createJobSeekerRequests) throws Exception{
		createJobSeekerRequests.setUserStatu(2);
		return ResponseEntity.ok(this.jobSeekerService.add(createJobSeekerRequests));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody() UpdateJobSeekerRequest updateJobSeekerRequest, int id){
		return ResponseEntity.ok(this.jobSeekerService.update(updateJobSeekerRequest, id));
	}
	
	@DeleteMapping("/delete/{id}")
	public Result delete(int id) {
		return this.jobSeekerService.delete(id);
	}
	

}
