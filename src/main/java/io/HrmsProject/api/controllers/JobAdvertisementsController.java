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

import io.HrmsProject.business.abstracts.JobAdvertisementService;
import io.HrmsProject.business.requests.jobAdvertisementRequests.CreateJobAdvertisementRequests;
import io.HrmsProject.business.requests.jobAdvertisementRequests.UpdateJobAdvertisementRequests;
import io.HrmsProject.business.responses.jobAdvertisementResponses.GetAllJobAdvertisementResponses;
import io.HrmsProject.business.responses.jobAdvertisementResponses.GetByIdJobAdvertisementResponse;
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
	
	@GetMapping("/getById")
	public GetByIdJobAdvertisementResponse getById(@PathVariable int id){
		return jobAdvertisementService.getById(id);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisement>> getAllByIsActive(@RequestParam boolean isActive){
		return this.jobAdvertisementService.getAllByIsActive(isActive);
	}
	
	@GetMapping("/getByJobAdvertisementDetailSorted")
	public DataResult<List<JobAdvertisement>> getJobAdvertisementDetailSorted()
	{
		return this.jobAdvertisementService.getJobAdvertisementDetailSorted();
	}
	
	@GetMapping("/getDetailsSortedByEmployerId")
	public DataResult<List<JobAdvertisement>> getDetailsSortedByEmployerId(@RequestParam int employerId)
	{
		return this.jobAdvertisementService.getByIsActiveAndEmployerId( employerId);
	}
	
	@GetMapping("/getByCompanyName")
	public  ResponseEntity<?> getByCompanyName(@RequestParam String companyName)
	{
		return ResponseEntity.ok(this.jobAdvertisementService.getByCompanyName(companyName));
	}
	
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateJobAdvertisementRequests createJobAdvertisementRequests) throws Exception{
		return ResponseEntity.ok(this.jobAdvertisementService.add(createJobAdvertisementRequests));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateJobAdvertisementRequests updateJobAdvertisement)throws Exception{
		return ResponseEntity.ok(this.jobAdvertisementService.update(updateJobAdvertisement));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@PathVariable int id) {
		return this.jobAdvertisementService.delete(id);
	}
	
	@PutMapping("/makeActiveOrPassive")
	public ResponseEntity<?> makeActiveOrPassive(@RequestParam boolean isActive, @RequestParam int id){
		return ResponseEntity.ok(this.jobAdvertisementService.makeActiveOrPassive(isActive, id));
	}
	
	
}
