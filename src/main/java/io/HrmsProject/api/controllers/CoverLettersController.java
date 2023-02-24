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

import io.HrmsProject.business.abstracts.CoverLetterService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.CoverLetter;

@RestController
@RequestMapping("api/coverLetters")
public class CoverLettersController {
	
	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CoverLetter>> getAll(){
		return coverLetterService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<CoverLetter> getById(int id){
		return coverLetterService.getById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() CoverLetter coverLetter) throws Exception{
		return ResponseEntity.ok(this.coverLetterService.add(coverLetter));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() CoverLetter coverLetter,int id){
		return ResponseEntity.ok(this.coverLetterService.update(coverLetter, id));
	}
	
	@DeleteMapping("/delete")
	public Result delete(int id) {
		return this.coverLetterService.delete(id);
	}
	

}
