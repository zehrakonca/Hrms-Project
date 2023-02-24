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

import io.HrmsProject.business.abstracts.LanguageService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.Language;

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
	public DataResult<List<Language>> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Language> getById(int id){
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() Language language) throws Exception{
		return ResponseEntity.ok(this.languageService.add(language));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() Language language,int id){
		return ResponseEntity.ok(this.languageService.update(language, id));
	}
	
	@DeleteMapping("/delete")
	public Result delete(int id) {
		return this.languageService.delete(id);
	}

}
