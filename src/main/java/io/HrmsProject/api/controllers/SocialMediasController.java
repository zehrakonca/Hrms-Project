package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.SocialMediaService;
import io.HrmsProject.business.requests.socialMediaRequests.CreateSocialMediaRequest;
import io.HrmsProject.business.requests.socialMediaRequests.UpdateSocialMediaRequest;
import io.HrmsProject.business.responses.socialMediaResponses.GetAllSocialMediaResponse;
import io.HrmsProject.business.responses.socialMediaResponses.GetByIdJobSeekerSocialMediaResponse;
import io.HrmsProject.business.responses.socialMediaResponses.GetByIdSocialMediaResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("api/socialMedias")
@CrossOrigin
public class SocialMediasController {

	private SocialMediaService socialMediaService;

	@Autowired
	public SocialMediasController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllSocialMediaResponse>> getAll(){
		return socialMediaService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdSocialMediaResponse> getById(@RequestParam() int id){
		return socialMediaService.getById(id);
	}
	
	@GetMapping("/getByJobSeekerId")
	public GetByIdJobSeekerSocialMediaResponse getByJobSeekerId(int jobSeeker){
		return socialMediaService.getByJobSeekerId(jobSeeker);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody() CreateSocialMediaRequest socialMedia) throws Exception{
		return ResponseEntity.ok(this.socialMediaService.add(socialMedia));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateSocialMediaRequest socialMedia)throws Exception{
		return ResponseEntity.ok(this.socialMediaService.update(socialMedia));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam() int id) {
		return this.socialMediaService.delete(id);
	}
}
