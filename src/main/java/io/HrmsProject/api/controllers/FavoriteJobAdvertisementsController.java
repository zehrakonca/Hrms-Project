package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.FavoriteJobAdvertisementService;
import io.HrmsProject.business.requests.favoriteJobAdvertisementRequests.CreateFavoriteJobAdvertisementRequest;
import io.HrmsProject.business.responses.favoriteJobAdvertisementResponses.GetAllFavoriteJobAdvertisementResponse;
import io.HrmsProject.business.responses.favoriteJobAdvertisementResponses.GetByIdFavoriteJobAdvertisementResponse;
import io.HrmsProject.business.responses.favoriteJobAdvertisementResponses.GetByJobSeekerIdFavoriteJobAdvertisementResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/favoriteJobAdvertisements")
public class FavoriteJobAdvertisementsController {
	
	private FavoriteJobAdvertisementService favoriteJobAdvertisementService;

	@Autowired
	public FavoriteJobAdvertisementsController(FavoriteJobAdvertisementService favoriteJobAdvertisementService) {
		super();
		this.favoriteJobAdvertisementService = favoriteJobAdvertisementService;
	}
	
	@GetMapping
	public DataResult<List<GetAllFavoriteJobAdvertisementResponse>> getAll(){
		return favoriteJobAdvertisementService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdFavoriteJobAdvertisementResponse> getById(@RequestParam() int id){
		return favoriteJobAdvertisementService.getById(id);
	}
	
	@GetMapping("/getByJobSeekerId")
	public DataResult<List<GetByJobSeekerIdFavoriteJobAdvertisementResponse>>  getByJobSeekerId(@RequestParam() int jobSeekerId){
		return favoriteJobAdvertisementService.getByJobSeeker_Id(jobSeekerId);
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateFavoriteJobAdvertisementRequest createFavoriteJobAdvertisementRequests) throws Exception{
		return ResponseEntity.ok(this.favoriteJobAdvertisementService.add(createFavoriteJobAdvertisementRequests));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@PathVariable int id) {
		return this.favoriteJobAdvertisementService.delete(id);
	}
	
	

}
