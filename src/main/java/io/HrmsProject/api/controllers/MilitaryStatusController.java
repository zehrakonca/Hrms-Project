package io.HrmsProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import io.HrmsProject.business.abstracts.MilitaryStatuService;
import io.HrmsProject.business.requests.militaryStatuRequests.CreateMilitaryStatuRequest;
import io.HrmsProject.business.requests.militaryStatuRequests.UpdateMilitaryStatuRequest;
import io.HrmsProject.business.responses.militaryStatuResponses.GetAllMilitaryStatuResponse;
import io.HrmsProject.business.responses.militaryStatuResponses.GetByIdMilitaryStatuResponse;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/militaryStatus")
@CrossOrigin
public class MilitaryStatusController {
	
	private MilitaryStatuService militaryStatuService;

	@Autowired
	public MilitaryStatusController(MilitaryStatuService militaryStatuService) {
		super();
		this.militaryStatuService = militaryStatuService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllMilitaryStatuResponse>> getAll(){
		return militaryStatuService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdMilitaryStatuResponse> getById(@RequestParam() int id){
		return militaryStatuService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid CreateMilitaryStatuRequest createMilitaryStatu) throws Exception {
		this.militaryStatuService.add(createMilitaryStatu);
		
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateMilitaryStatuRequest updateMilitaryStatu) throws Exception {
		this.militaryStatuService.update(updateMilitaryStatu);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) {
	 this.militaryStatuService.delete(id);
	}

}
