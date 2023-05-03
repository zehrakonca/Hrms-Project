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

import io.HrmsProject.business.abstracts.JobService;
import io.HrmsProject.business.requests.jobRequests.CreateJobRequests;
import io.HrmsProject.business.requests.jobRequests.UpdateJobRequests;
import io.HrmsProject.business.responses.jobResponses.GetAllJobResponses;
import io.HrmsProject.business.responses.jobResponses.GetByIdJobResponse;
import io.HrmsProject.business.responses.jobResponses.GetByIdSectorJobResponse;
import io.HrmsProject.business.responses.jobResponses.GetByJobNameAndSectorResponse;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin
public class JobsController {
	
	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllJobResponses>> getAll(){
		return jobService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdJobResponse> getById(int id) {
		return this.jobService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateJobRequests createJobRequests) throws Exception {
		return ResponseEntity.ok(this.jobService.add(createJobRequests));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam() int id) {
		return ResponseEntity.ok(this.jobService.delete(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateJobRequests updateJobRequests) throws Exception {
		return ResponseEntity.ok(this.jobService.update(updateJobRequests));
	}
	
	@GetMapping("/getByJobNameAndSectorId")
	public DataResult<List<GetByJobNameAndSectorResponse>> getByJobNameAndSectorId(@RequestParam() String jobName){
		return this.jobService.getByNameAndSector(jobName);
	}
	
	@GetMapping("/getBySector")
	public DataResult<List<GetByIdSectorJobResponse>> getBySectorId(@RequestParam() int sectorId) {
		return this.jobService.getBySectorId(sectorId);
	}
}

