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

import io.HrmsProject.business.abstracts.FacultyService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Faculty;

@RestController
@RequestMapping("/api/faculties")
public class FacultiesController {
	private FacultyService facultyService;

	@Autowired
	public FacultiesController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() Faculty faculty){
		return ResponseEntity.ok(this.facultyService.add(faculty));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody() Faculty faculty, int id){
		return ResponseEntity.ok(this.facultyService.update(faculty, id));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Faculty>> getAll(){
		return this.facultyService.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@RequestBody() int id){
		return ResponseEntity.ok(this.facultyService.delete(id));
	}
	
	@GetMapping("/getById")
	public DataResult<Faculty> getById(int id){
		return this.facultyService.getById(id);
	}
}
