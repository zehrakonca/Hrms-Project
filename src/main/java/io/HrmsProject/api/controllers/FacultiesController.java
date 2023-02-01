package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.FacultyService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.Faculty;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/faculties")
public class FacultiesController {

	private FacultyService facultyService;
	
	@Autowired
	public FacultiesController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Faculty>> getAll(){
		return this.facultyService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Faculty> getById(int id){
		return this.facultyService.getById(id);
	}
	
	@GetMapping("/getByCompanyName")
	public ResponseEntity<?> getByFacultyName(@RequestParam() String facultyName){
		return ResponseEntity.ok(this.facultyService.getByFacultyName(facultyName));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() Faculty faculty){
		return ResponseEntity.ok(this.facultyService.add(faculty));
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody() Faculty faculty, int id){
		return ResponseEntity.ok(this.facultyService.update(faculty, id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@RequestBody() int id){
		return ResponseEntity.ok(this.facultyService.delete(id));
	}
	
	
	
	
}
