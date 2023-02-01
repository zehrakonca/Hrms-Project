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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.JobAdvertisementService;
import io.HrmsProject.business.requests.jobAdvertisementRequests.CreateJobAdvertisementRequests;
import io.HrmsProject.business.requests.jobAdvertisementRequests.UpdateJobAdvertisementRequests;
import io.HrmsProject.business.responses.jobAdvertisementResponses.GetAllJobAdvertisementResponses;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllJobAdvertisementResponses>> getAll(){
		return jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllByIsActive")
	public DataResult<List<JobAdvertisement>> getAllByIsActive(@RequestParam boolean isActive){
		return this.jobAdvertisementService.getAllByIsActive(isActive);
	}
	
	@GetMapping("/getDetailsSorted")
	public DataResult<List<JobAdvertisement>> getJobAdvertisementDetailSorted()
	{
		return this.jobAdvertisementService.getJobAdvertisementDetailSorted();
	}
	
	@GetMapping("/getDetailsSortedByEmployerId")
	public DataResult<List<JobAdvertisement>> getDetailsSortedByEmployerId(@RequestParam int employerId)
	{
		return this.jobAdvertisementService.getByIsActiveAndEmployerId( employerId);
	}
	
	@GetMapping("/getDetailsByCompanyName")
	public  ResponseEntity<?> getByCompanyName(@RequestParam String companyName)
	{
		return ResponseEntity.ok(this.jobAdvertisementService.getByCompanyName(companyName));
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() CreateJobAdvertisementRequests createJobAdvertisementRequests) throws Exception{
		return ResponseEntity.ok(this.jobAdvertisementService.add(createJobAdvertisementRequests));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateJobAdvertisementRequests updateJobAdvertisement,int id){
		return ResponseEntity.ok(this.jobAdvertisementService.update(updateJobAdvertisement, id));
	}
	
	@DeleteMapping("/delete")
	public Result delete(int id) {
		return this.jobAdvertisementService.delete(id);
	}
	
	@PutMapping("/makeActiveOrPassive")
	public ResponseEntity<?> makeActiveOrPassive(@RequestParam boolean isActive, @RequestParam int id){
		return ResponseEntity.ok(this.jobAdvertisementService.makeActiveOrPassive(isActive, id));
	}
}
