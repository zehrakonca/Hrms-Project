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

import io.HrmsProject.business.abstracts.SocialMediaService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.SocialMedia;

@RestController
@RequestMapping("api/socialMedias")
public class SocialMediasController {

	private SocialMediaService socialMediaService;

	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SocialMedia>> getAll(){
		return socialMediaService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<SocialMedia> getById(int id){
		return socialMediaService.getById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() SocialMedia socialMedia) throws Exception{
		return ResponseEntity.ok(this.socialMediaService.add(socialMedia));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() SocialMedia socialMedia,int id){
		return ResponseEntity.ok(this.socialMediaService.update(socialMedia, id));
	}
	
	@DeleteMapping("/delete")
	public Result delete(int id) {
		return this.socialMediaService.delete(id);
	}
}
