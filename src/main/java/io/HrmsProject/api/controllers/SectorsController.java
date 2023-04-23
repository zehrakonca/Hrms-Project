package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.SectorService;
import io.HrmsProject.business.requests.sectorRequests.CreateSectorRequests;
import io.HrmsProject.business.requests.sectorRequests.UpdateSectorRequests;
import io.HrmsProject.business.responses.sectorResponses.GetAllSectorResponse;
import io.HrmsProject.business.responses.sectorResponses.GetByIdSectorResponse;
import io.HrmsProject.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/sectors")
public class SectorsController {
	
	private SectorService sectorService;

	@Autowired
	public SectorsController(SectorService sectorService) {
		super();
		this.sectorService = sectorService;
	}
	
	@GetMapping
	public DataResult<List<GetAllSectorResponse>> getAll(){
		return sectorService.getAll();
	}
	
	@GetMapping("/{id}")
	public DataResult<GetByIdSectorResponse> getById(@PathVariable int id) {
		return this.sectorService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateSectorRequests createSectorRequests) throws Exception{
		this.sectorService.add(createSectorRequests);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws Exception {
		this.sectorService.delete(id);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateSectorRequests updateSectorRequests) throws Exception {
		this.sectorService.update(updateSectorRequests);
	}
	
	
}
