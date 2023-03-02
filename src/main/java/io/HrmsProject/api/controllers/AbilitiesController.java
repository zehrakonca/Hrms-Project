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

import io.HrmsProject.business.abstracts.AbilityService;
import io.HrmsProject.business.requests.abilityRequests.CreateAbilityRequests;
import io.HrmsProject.business.requests.abilityRequests.UpdateAbilityRequests;
import io.HrmsProject.business.responses.abilityResponses.GetAllAbilityResponses;
import io.HrmsProject.business.responses.abilityResponses.GetByIdAbilityResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

@RestController
@RequestMapping("api/abilities")
public class AbilitiesController {
	
	private AbilityService abilityService;

	@Autowired
	public AbilitiesController(AbilityService abilityService) {
		super();
		this.abilityService = abilityService;
	}
	
	@GetMapping
	public DataResult<List<GetAllAbilityResponses>> getAll(){
		return abilityService.getAll();
	}
	
	@GetMapping("/getById")
	public GetByIdAbilityResponse getById(@PathVariable int id){
		return abilityService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateAbilityRequests createAbility) throws Exception{
		return ResponseEntity.ok(this.abilityService.add(createAbility));
	}
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateAbilityRequests updateAbilityRequests) throws Exception{
		return ResponseEntity.ok(this.abilityService.update(updateAbilityRequests));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@PathVariable int id) {
		return this.abilityService.delete(id);
	}
	

}
