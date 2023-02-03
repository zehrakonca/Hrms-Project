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

import io.HrmsProject.business.abstracts.HighSchoolService;
import io.HrmsProject.business.requests.highSchool.CreateHighSchoolInfoRequests;
import io.HrmsProject.business.requests.highSchool.UpdateHighSchoolInfoRequests;
import io.HrmsProject.business.responses.highSchoolResponses.GetAllHighSchoolResponses;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/highSchools")
public class HighSchoolsController {
	
	private HighSchoolService highSchoolService;

	@Autowired
	public HighSchoolsController(HighSchoolService highSchoolService) {
		super();
		this.highSchoolService = highSchoolService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllHighSchoolResponses>> getAll(){
		return highSchoolService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() CreateHighSchoolInfoRequests createHighSchoolInfoRequests) throws Exception{
		return ResponseEntity.ok(this.highSchoolService.add(createHighSchoolInfoRequests));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateHighSchoolInfoRequests updateHighSchoolInfoRequests,int id){
		return ResponseEntity.ok(this.highSchoolService.update(updateHighSchoolInfoRequests, id));
	}
	
	@DeleteMapping("/delete")
	public Result delete(int id) {
		return this.highSchoolService.delete(id);
	}
	

}
