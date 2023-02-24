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

import io.HrmsProject.business.abstracts.LanguageInfoService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.LanguageInfo;

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
	public DataResult<List<LanguageInfo>> getAll(){
		return languageInfoService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<LanguageInfo> getById(int id){
		return languageInfoService.getById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() LanguageInfo language) throws Exception{
		return ResponseEntity.ok(this.languageInfoService.add(language));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() LanguageInfo language,int id){
		return ResponseEntity.ok(this.languageInfoService.update(language, id));
	}
	
	@DeleteMapping("/delete")
	public Result delete(int id) {
		return this.languageInfoService.delete(id);
	}
}
