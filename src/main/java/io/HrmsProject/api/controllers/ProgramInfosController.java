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

import io.HrmsProject.business.abstracts.ProgramInfoService;
import io.HrmsProject.business.requests.programRequests.CreateProgramRequest;
import io.HrmsProject.business.requests.programRequests.UpdateProgramRequest;
import io.HrmsProject.business.responses.programResponses.GetAllProgramResponse;
import io.HrmsProject.business.responses.programResponses.GetByIdProgramResponse;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/programInfos")
public class ProgramInfosController {
	
	private ProgramInfoService programInfoService;
	
	@Autowired
	public ProgramInfosController(ProgramInfoService programInfoService) {
		super();
		this.programInfoService = programInfoService;
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<?> add(@RequestBody() CreateProgramRequest programInfo) throws Exception{
		return ResponseEntity.ok(this.programInfoService.add(programInfo));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() UpdateProgramRequest programInfo) throws Exception{
		return ResponseEntity.ok(this.programInfoService.update(programInfo));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllProgramResponse>> getAll(){
		return this.programInfoService.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return ResponseEntity.ok(this.programInfoService.delete(id));
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdProgramResponse getById(@PathVariable int id){
		return this.programInfoService.getById(id);
	}

}
