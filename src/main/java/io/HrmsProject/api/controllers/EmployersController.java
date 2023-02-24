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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.EmployerService;
import io.HrmsProject.business.requests.employerRequests.CreateEmployerRequests;
import io.HrmsProject.business.requests.employerRequests.UpdateEmployerRequests;
import io.HrmsProject.business.responses.employerResponses.GetAllEmployerResponses;
import io.HrmsProject.business.responses.employerResponses.GetByIdEmployerResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllEmployerResponses>> getAll(){
		return employerService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Employer> getById(@PathVariable int id){
		return this.employerService.getById(id);
	}
	
	@GetMapping("{id}")
	public DataResult<GetByIdEmployerResponse> getByEmployerId(@PathVariable int id){
		return this.employerService.getByEmployerId(id);
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateEmployerRequests createEmployerRequests) throws Exception {
		return ResponseEntity.ok(this.employerService.add(createEmployerRequests));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody() UpdateEmployerRequests updateEmployerRequests, int id) throws Exception {
		return ResponseEntity.ok(this.employerService.update(updateEmployerRequests));
	}
	
	@DeleteMapping("/delete/{id}")
	public Result delete(int id) {
		return this.employerService.delete(id);
	}

}
