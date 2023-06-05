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

import io.HrmsProject.business.abstracts.SystemEmployeeService;
import io.HrmsProject.business.requests.systemEmployeeRequests.CreateSystemEmployeeRequest;
import io.HrmsProject.business.requests.systemEmployeeRequests.UpdateSystemEmployeeRequest;
import io.HrmsProject.business.responses.systemEmployeeResponses.GetAllSystemEmployeeResponse;
import io.HrmsProject.business.responses.systemEmployeeResponses.GetByIdSystemEmployeeResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/systemEmployees")
@CrossOrigin
@RequiredArgsConstructor
public class SystemEmployeesController {

	private SystemEmployeeService systemEmployeeService;

	@Autowired
	public SystemEmployeesController(SystemEmployeeService systemEmployeeService) {
		super();
		this.systemEmployeeService = systemEmployeeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllSystemEmployeeResponse>> getAll(){
		return systemEmployeeService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdSystemEmployeeResponse> getById(@RequestParam() int id){
		return this.systemEmployeeService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateSystemEmployeeRequest createSystemEmployeeRequests) throws Exception{
		return ResponseEntity.ok(this.systemEmployeeService.add(createSystemEmployeeRequests));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateSystemEmployeeRequest updateSystemEmployeeRequests)throws Exception{
		return ResponseEntity.ok(this.systemEmployeeService.update(updateSystemEmployeeRequests));
	}
	
	@DeleteMapping("/deleteById")
	public Result delete(@RequestParam() int id) {
		return this.systemEmployeeService.delete(id);
	}
	
	@PutMapping("/makeActiveOrPassive")
	public ResponseEntity<?> makeActiveOrPassive(@RequestParam boolean isActive, @RequestParam int id){
		return ResponseEntity.ok(this.systemEmployeeService.makeActiveOrPassive(isActive, id));
	}
	
}
