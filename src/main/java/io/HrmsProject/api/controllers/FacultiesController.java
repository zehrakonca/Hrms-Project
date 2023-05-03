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

import io.HrmsProject.business.abstracts.FacultyService;
import io.HrmsProject.business.requests.facultyRequests.CreateFacultyRequests;
import io.HrmsProject.business.requests.facultyRequests.UpdateFacultyRequests;
import io.HrmsProject.business.responses.facultyResponses.GetAllFacultyResponse;
import io.HrmsProject.business.responses.facultyResponses.GetByIdFacultyResponse;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/faculties")
@CrossOrigin
public class FacultiesController {
	private FacultyService facultyService;

	@Autowired
	public FacultiesController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateFacultyRequests faculty) throws Exception{
		return ResponseEntity.ok(this.facultyService.add(faculty));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateFacultyRequests faculty)throws Exception{
		return ResponseEntity.ok(this.facultyService.update(faculty));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllFacultyResponse>> getAll(){
		return this.facultyService.getAll();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id){
		return ResponseEntity.ok(this.facultyService.delete(id));
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdFacultyResponse> getById(@RequestParam() int id){
		return this.facultyService.getById(id);
	}
}
