package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.HighSchoolTypeService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.HighSchoolType;

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
	public ResponseEntity<?> add(@RequestBody() HighSchoolType highSchoolType){
		return ResponseEntity.ok(this.highSchoolService.add(highSchoolType));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<HighSchoolType>> getAll(){
		return this.highSchoolService.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@RequestBody() int id){
		return ResponseEntity.ok(this.highSchoolService.delete(id));
	}
	
	@GetMapping("/getById")
	public DataResult<HighSchoolType> getById(int id){
		return this.highSchoolService.getById(id);
	}
}

