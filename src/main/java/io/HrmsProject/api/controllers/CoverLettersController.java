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

import io.HrmsProject.business.abstracts.CoverLetterService;
import io.HrmsProject.business.requests.coverLetterRequests.CreateCoverLetterRequests;
import io.HrmsProject.business.requests.coverLetterRequests.UpdateCoverLetterRequests;
import io.HrmsProject.business.responses.coverLetterResponses.GetAllCoverLetterResponses;
import io.HrmsProject.business.responses.coverLetterResponses.GetByIdCoverLetterResponses;
import io.HrmsProject.business.responses.coverLetterResponses.GetByIdJobSeekerCoverLetterResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("api/coverLetters")
@CrossOrigin
public class CoverLettersController {
	
	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllCoverLetterResponses>> getAll(){
		return coverLetterService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdCoverLetterResponses> getById(@RequestParam() int id){
		return coverLetterService.getById(id);
	}
	
	@GetMapping("/getByJobSeekerId")
	public DataResult<List<GetByIdJobSeekerCoverLetterResponse>> getByJobSeeker(@RequestParam() int jobSeekerId){
		return coverLetterService.getByJobSeeker(jobSeekerId);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateCoverLetterRequests coverLetter) throws Exception{
		return ResponseEntity.ok(this.coverLetterService.add(coverLetter));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateCoverLetterRequests coverLetter)throws Exception{
		return ResponseEntity.ok(this.coverLetterService.update(coverLetter));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.coverLetterService.delete(id);
	}
	

}
