package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.JobService;
import io.HrmsProject.business.requests.jobRequests.CreateJobRequests;
import io.HrmsProject.business.requests.jobRequests.UpdateJobRequests;
import io.HrmsProject.business.responses.jobResponses.GetAllJobResponses;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllJobResponses> getAll(){
		return jobService.getAll();
	}
	
	@GetMapping("/getById")
	public Job getById(int id) {
		return this.jobService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateJobRequests createJobRequests) throws Exception {
		this.jobService.add(createJobRequests);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@RequestBody() int id) {
		this.jobService.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody() UpdateJobRequests updateJobRequests, int id) throws Exception {
		this.jobService.update(updateJobRequests, id);
	}
	
	@GetMapping("/getByJobNameAndSectorId")
	public DataResult<List<Job>> getByJobNameAndSectorId(@RequestParam("jobName") String jobName, @RequestParam("sectorId") int sectorId){
		return this.jobService.getByNameAndSector(jobName, sectorId);
	}
	
	@GetMapping("/getBySector")
	public DataResult<List<Job>> getBySectorId(@RequestParam("sectorId") int sectorId) {
		return this.jobService.getBySectorId(sectorId);
	}

}
