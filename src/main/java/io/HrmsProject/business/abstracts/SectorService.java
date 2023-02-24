package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.sectorRequests.CreateSectorRequests;
import io.HrmsProject.business.requests.sectorRequests.UpdateSectorRequests;
import io.HrmsProject.business.responses.sectorResponses.GetAllSectorResponse;
import io.HrmsProject.entities.concretes.Sector;

public interface SectorService {
	
	void add(CreateSectorRequests createSectorRequests) throws Exception;
	void delete(int id) throws Exception;
	void update(UpdateSectorRequests updateSectorRequests) throws Exception;
	
	public List<GetAllSectorResponse> getAll();
	
	public Sector getById(int id);
}
