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

import io.HrmsProject.business.abstracts.HighSchoolService;
import io.HrmsProject.business.requests.highSchoolRequests.CreateHighSchoolInfoRequests;
import io.HrmsProject.business.requests.highSchoolRequests.UpdateHighSchoolInfoRequests;
import io.HrmsProject.business.responses.highSchoolResponses.GetAllHighSchoolResponses;
import io.HrmsProject.business.responses.highSchoolResponses.GetByIdHighSchoolResponse;
import io.HrmsProject.business.responses.highSchoolResponses.GetByJobSeekerIdResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/highSchools")
@CrossOrigin
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
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateHighSchoolInfoRequests createHighSchoolInfoRequests) throws Exception{
		return ResponseEntity.ok(this.highSchoolService.add(createHighSchoolInfoRequests));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateHighSchoolInfoRequests updateHighSchoolInfoRequests)throws Exception{
		return ResponseEntity.ok(this.highSchoolService.update(updateHighSchoolInfoRequests));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.highSchoolService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdHighSchoolResponse> getById(@RequestParam() int id){
		return this.highSchoolService.getById(id);
	}
	
	@GetMapping("/getByJobSeekerId")
	public DataResult<GetByJobSeekerIdResponse> getByJobSeekerId(@RequestParam() int jobSeekerId){
		return this.highSchoolService.getByJobSeekerId(jobSeekerId);
	}
	

}
