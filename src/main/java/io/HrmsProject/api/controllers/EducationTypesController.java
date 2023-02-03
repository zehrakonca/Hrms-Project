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
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.EducationTypeService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.EducationType;

@RestController
@RequestMapping("/api/educationTypes")
public class EducationTypesController {
	
	private EducationTypeService educationTypeService;
	
	@Autowired
	public EducationTypesController(EducationTypeService educationTypeService) {
		super();
		this.educationTypeService = educationTypeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() EducationType educationType){
		return ResponseEntity.ok(this.educationTypeService.add(educationType));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody() EducationType educationType, int id){
		return ResponseEntity.ok(this.educationTypeService.update(educationType, id));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<EducationType>> getAll(){
		return this.educationTypeService.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@RequestBody() int id){
		return ResponseEntity.ok(this.educationTypeService.delete(id));
	}
	
	@GetMapping("/getById")
	public DataResult<EducationType> getById(int id){
		return this.educationTypeService.getById(id);
	}
	
}
