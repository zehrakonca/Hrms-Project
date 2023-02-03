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

import io.HrmsProject.business.abstracts.UniversityService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.University;

@RestController
@RequestMapping("/api/universities")
public class UniversitiesController {
	
	private UniversityService universityService;
	
	@Autowired
	public UniversitiesController(UniversityService universityService) {
		super();
		this.universityService = universityService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() University university){
		return ResponseEntity.ok(this.universityService.add(university));
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody() University university, int id){
		return ResponseEntity.ok(this.universityService.update(university,id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@RequestBody() int id){
		return ResponseEntity.ok(this.universityService.delete(id));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<University>> getAll(){
		return this.universityService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<University> getById(int id){
		return this.universityService.getById(id);
	}

}
