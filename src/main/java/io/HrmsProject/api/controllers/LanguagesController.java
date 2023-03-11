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

import io.HrmsProject.business.abstracts.LanguageService;
import io.HrmsProject.business.requests.languageRequests.CreateLanguageRequest;
import io.HrmsProject.business.requests.languageRequests.UpdateLanguageRequest;
import io.HrmsProject.business.responses.languageResponse.GetAllLanguageResponse;
import io.HrmsProject.business.responses.languageResponse.GetByIdLanguageResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("api/languages")
public class LanguagesController {
	
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllLanguageResponse>> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdLanguageResponse getById(@PathVariable int id){
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateLanguageRequest language) throws Exception{
		return ResponseEntity.ok(this.languageService.add(language));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateLanguageRequest language)throws Exception{
		return ResponseEntity.ok(this.languageService.update(language));
	}
	
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return this.languageService.delete(id);
	}

}
