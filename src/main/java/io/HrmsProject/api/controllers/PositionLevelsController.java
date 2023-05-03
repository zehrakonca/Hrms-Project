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

import io.HrmsProject.business.abstracts.PositionLevelService;
import io.HrmsProject.business.requests.positionLevelRequests.CreatePositionLevelRequest;
import io.HrmsProject.business.requests.positionLevelRequests.UpdatePositionLevelRequest;
import io.HrmsProject.business.responses.positionLevelResponses.GetAllPositionLevelResponse;
import io.HrmsProject.business.responses.positionLevelResponses.GetByIdPositionLevelResponse;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/positionLevels")
@CrossOrigin
public class PositionLevelsController {
	
	private PositionLevelService positionLevelService;

	@Autowired
	public PositionLevelsController(PositionLevelService positionLevelService) {
		super();
		this.positionLevelService = positionLevelService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllPositionLevelResponse>> getAll(){
		return positionLevelService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdPositionLevelResponse> getById(@RequestParam() int id){
		return positionLevelService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid CreatePositionLevelRequest createPositionLevel) throws Exception {
		this.positionLevelService.add(createPositionLevel);
		
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdatePositionLevelRequest updatePositionLevel) throws Exception {
		this.positionLevelService.update(updatePositionLevel);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) {
	 this.positionLevelService.delete(id);
	}
	

}
