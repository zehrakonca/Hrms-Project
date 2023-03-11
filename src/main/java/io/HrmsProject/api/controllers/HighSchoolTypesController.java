package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.HighSchoolTypeService;
import io.HrmsProject.business.requests.highSchoolTypeRequests.CreateHighSchoolTypeRequest;
import io.HrmsProject.business.requests.highSchoolTypeRequests.UpdateHighSchoolTypeRequest;
import io.HrmsProject.business.responses.highSchoolTypeResponses.GetAllHighSchoolTypeResponse;
import io.HrmsProject.business.responses.highSchoolTypeResponses.GetByIdHighSchoolTypeResponse;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/highSchoolTypes")
public class HighSchoolTypesController {
	
	private HighSchoolTypeService highSchoolService;
	
	@Autowired
	public HighSchoolTypesController(HighSchoolTypeService highSchoolService) {
		super();
		this.highSchoolService = highSchoolService;
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateHighSchoolTypeRequest highSchoolType) throws Exception{
		return ResponseEntity.ok(this.highSchoolService.add(highSchoolType));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> add(@RequestBody() UpdateHighSchoolTypeRequest highSchoolType) throws Exception{
		return ResponseEntity.ok(this.highSchoolService.update(highSchoolType));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllHighSchoolTypeResponse>> getAll(){
		return this.highSchoolService.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@RequestBody() int id){
		return ResponseEntity.ok(this.highSchoolService.delete(id));
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdHighSchoolTypeResponse> getById(@RequestParam() int id){
		return this.highSchoolService.getById(id);
	}
}

