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

import io.HrmsProject.business.abstracts.ProgramInfoService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.ProgramInfo;

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
	public ResponseEntity<?> add(@RequestBody() ProgramInfo programInfo){
		return ResponseEntity.ok(this.programInfoService.add(programInfo));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody() ProgramInfo programInfo, int id) {
		return ResponseEntity.ok(this.programInfoService.update(programInfo, id));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ProgramInfo>> getAll(){
		return this.programInfoService.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@RequestBody() int id){
		return ResponseEntity.ok(this.programInfoService.delete(id));
	}
	
	@GetMapping("/getById")
	public DataResult<ProgramInfo> getById(int id){
		return this.programInfoService.getById(id);
	}

}
