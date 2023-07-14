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

import io.HrmsProject.business.abstracts.JobApplicationService;
import io.HrmsProject.business.requests.jobApplicationRequests.CreateJobApplicationRequest;
import io.HrmsProject.business.requests.jobApplicationRequests.UpdateJobApplicationRequest;
import io.HrmsProject.business.responses.jobApplicationResponses.GetAllJobApplicationResponse;
import io.HrmsProject.business.responses.jobApplicationResponses.GetByEmployerIdJobApplicationResponse;
import io.HrmsProject.business.responses.jobApplicationResponses.GetByIdJobApplicationResponse;
import io.HrmsProject.business.responses.jobApplicationResponses.GetByJobSeekerIdJobApplicationResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("api/jobApplications")
@CrossOrigin
public class JobApplicationsController {
	
	private JobApplicationService jobApplicationService;

	@Autowired
	public JobApplicationsController(JobApplicationService jobApplicationService) {
		super();
		this.jobApplicationService = jobApplicationService;
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateJobApplicationRequest createJobApplication) throws Exception{
		return ResponseEntity.ok(this.jobApplicationService.add(createJobApplication));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateJobApplicationRequest updateJobApplicationRequest) throws Exception{
		return ResponseEntity.ok(this.jobApplicationService.update(updateJobApplicationRequest));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.jobApplicationService.delete(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllJobApplicationResponse>> getAll(){
		return jobApplicationService.getAll();
	}
	
	@GetMapping("/getByIdJobApplication")
	public DataResult<GetByIdJobApplicationResponse> getById(@RequestParam() int id){
		return jobApplicationService.getById(id);
	}
	
	@GetMapping("/getByJobSeekerId")
	public DataResult<List<GetByJobSeekerIdJobApplicationResponse>> getByJobSeekerId(@RequestParam() int jobSeekerId){
		return jobApplicationService.getByJobSeekerId(jobSeekerId);
	}
	
	@GetMapping("/getByEmployerId")
	public DataResult<List<GetByEmployerIdJobApplicationResponse>> getByEmployerId(@RequestParam() int employerId){
		return jobApplicationService.getByEmployerId(employerId);
	}

}
