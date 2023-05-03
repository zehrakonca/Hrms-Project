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

import io.HrmsProject.business.abstracts.EmployerService;
import io.HrmsProject.business.requests.employerRequests.CreateEmployerRequests;
import io.HrmsProject.business.requests.employerRequests.UpdateEmployerRequests;
import io.HrmsProject.business.responses.employerResponses.GetAllEmployerResponses;
import io.HrmsProject.business.responses.employerResponses.GetByIdEmployerResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
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
	public DataResult<GetByIdEmployerResponse> getById(@RequestParam() int id){
		return this.employerService.getById(id);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<GetAllEmployerResponses>> getByIsActive(@RequestParam boolean isActive){
		return this.employerService.getAllByIsActive(isActive);
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateEmployerRequests createEmployerRequests) throws Exception {
		return ResponseEntity.ok(this.employerService.add(createEmployerRequests));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateEmployerRequests updateEmployerRequests, int id) throws Exception {
		return ResponseEntity.ok(this.employerService.update(updateEmployerRequests));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.employerService.delete(id);
	}
	
	@PutMapping("/makeActiveOrPassive")
	public ResponseEntity<?> makeActiveOrPassive(@RequestParam boolean isActive, @RequestParam int id){
		return ResponseEntity.ok(this.employerService.makeActiveOrPassive(isActive, id));
	}

}
