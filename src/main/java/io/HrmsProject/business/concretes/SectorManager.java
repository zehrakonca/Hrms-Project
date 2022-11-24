package io.HrmsProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.SectorService;
import io.HrmsProject.business.requests.sectorRequests.CreateSectorRequests;
import io.HrmsProject.business.requests.sectorRequests.UpdateSectorRequests;
import io.HrmsProject.business.responses.sectorResponses.GetAllSectorResponse;
import io.HrmsProject.dataAccess.abstracts.SectorDao;
import io.HrmsProject.entities.concretes.Sector;

@Service
public class SectorManager implements SectorService{
	
	private SectorDao sectorDao;

	boolean isExist = false;
	
	@Autowired
	public SectorManager(SectorDao sectorDao) {
		super();
		this.sectorDao = sectorDao;
	}
	

	@Override
	public void add(CreateSectorRequests createSectorRequests) throws Exception {
		Sector sector = new Sector();
		sector.setSector(createSectorRequests.getSector());
		
		if(sector.getSector()==null || createSectorRequests.getSector().isEmpty()) {
			throw new Exception("sector information cannot be blank.");
		}
		else if(isSectorExist(createSectorRequests.getSector())==true) {
			throw new Exception("this sector already in list.");
		}
		else {
			this.sectorDao.save(sector);
		}
		
	}

	@Override
	public void delete(int id) {
		this.sectorDao.deleteById(id);
	}

	@Override
	public void update(UpdateSectorRequests updateSectorRequests, int id) throws Exception {
		Sector sector = sectorDao.findById(id);
		
		if(isSectorExist(updateSectorRequests.getSector())) {
			throw new Exception("this sector information already in list.");
		}
		else {
			sector.setSector(updateSectorRequests.getSector());
			this.sectorDao.save(sector);
		}
		
	}

	@Override
	public List<GetAllSectorResponse> getAll() {
		List<Sector> sectors = sectorDao.findAll();
		List<GetAllSectorResponse> sectorResponses = new ArrayList<GetAllSectorResponse>();
		
		for(Sector sector : sectors) {
			GetAllSectorResponse responseItem = new GetAllSectorResponse();
			responseItem.setId(sector.getSectorId());
			responseItem.setSector(sector.getSector());
			sectorResponses.add(responseItem);
		}
		return sectorResponses;
	}

	@Override
	public Sector getById(int id) {
		return this.sectorDao.findById(id);
	}
	
	private boolean isSectorExist(String sectorName) throws Exception{
		List<Sector> sectors = sectorDao.findAll();
		
		for(Sector sector : sectors) {
			if(sector.getSector().equalsIgnoreCase(sectorName)) {
				isExist=true;
			}
		}
		return isExist;
	}
	
}
