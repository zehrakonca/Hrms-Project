package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.LanguageInfoService;
import io.HrmsProject.business.requests.languageInfoRequests.CreateLanguageInfoRequest;
import io.HrmsProject.business.requests.languageInfoRequests.UpdateLanguageInfoRequest;
import io.HrmsProject.business.responses.languageInfoResponses.GetAllLanguageInfoResponse;
import io.HrmsProject.business.responses.languageInfoResponses.GetByIdJobSeekerLanguageInfoResponse;
import io.HrmsProject.business.responses.languageInfoResponses.GetByIdLanguageInfoResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("api/languageInfos")
public class LanguageInfosController {

	private LanguageInfoService languageInfoService;

	@Autowired
	public LanguageInfosController(LanguageInfoService languageInfoService) {
		super();
		this.languageInfoService = languageInfoService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllLanguageInfoResponse>> getAll(){
		return languageInfoService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdLanguageInfoResponse getById(@PathVariable int id){
		return languageInfoService.getById(id);
	}
	
	@GetMapping("/getByJobSeekerId/{id}")
	public DataResult<List<GetByIdJobSeekerLanguageInfoResponse>> getByJobSeeker(@PathVariable int id){
		return languageInfoService.getByJobSeekerId(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateLanguageInfoRequest language) throws Exception{
		return ResponseEntity.ok(this.languageInfoService.add(language));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateLanguageInfoRequest language)throws Exception{
		return ResponseEntity.ok(this.languageInfoService.update(language));
	}
	
	@DeleteMapping("/delete/{id}")
	public Result delete(int id) {
		return this.languageInfoService.delete(id);
	}
}
