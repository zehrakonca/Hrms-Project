package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.SectorService;
import io.HrmsProject.business.requests.sectorRequests.CreateSectorRequests;
import io.HrmsProject.business.requests.sectorRequests.UpdateSectorRequests;
import io.HrmsProject.business.responses.sectorResponses.GetAllSectorResponse;
import io.HrmsProject.entities.concretes.Sector;

@RestController
@RequestMapping("/api/sectors")
public class SectorsController {
	
	private SectorService sectorService;

	@Autowired
	public SectorsController(SectorService sectorService) {
		super();
		this.sectorService = sectorService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllSectorResponse> getAll(){
		return sectorService.getAll();
	}
	
	@GetMapping("/getById")
	public Sector getById(int id) {
		return this.sectorService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateSectorRequests createSectorRequests) throws Exception{
		this.sectorService.add(createSectorRequests);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(int id) {
		this.sectorService.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody() UpdateSectorRequests updateSectorRequests, int id) throws Exception {
		this.sectorService.update(updateSectorRequests, id);
	}
	
	
}
