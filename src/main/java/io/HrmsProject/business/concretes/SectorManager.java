package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.SectorService;
import io.HrmsProject.business.requests.sectorRequests.CreateSectorRequests;
import io.HrmsProject.business.requests.sectorRequests.UpdateSectorRequests;
import io.HrmsProject.business.responses.sectorResponses.GetAllSectorResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.dataAccess.abstracts.SectorDao;
import io.HrmsProject.entities.concretes.Sector;

@Service
public class SectorManager implements SectorService{
	
	private SectorDao sectorDao;
	private ModelMapperService modelMapperService;
	
	boolean isExist = false;
	
	@Autowired
	public SectorManager(SectorDao sectorDao, ModelMapperService modelMapperService) {
		super();
		this.sectorDao = sectorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void add(CreateSectorRequests createSectorRequests) throws Exception {
		Sector sector = this.modelMapperService.forRequest().map(createSectorRequests, Sector.class);
		
		if(sector.getSector()==null || createSectorRequests.getSector().isEmpty()) {
			throw new Exception("sector information cannot be blank.");
		}
		else if(isSectorExist(createSectorRequests.getSector())==true) {
			throw new Exception("this sector already in list.");
		}
		else {
			this.sectorDao.save(sector);
			throw new Exception("sector has been saved.");
		}
		
	}

	@Override
	public void delete(int id) {
		this.sectorDao.deleteById(id);
	}

	@Override
	public void update(UpdateSectorRequests updateSectorRequests) throws Exception {
		Sector sector = this.modelMapperService.forRequest().map(updateSectorRequests, Sector.class);
		
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
		
		List<GetAllSectorResponse> sectorResponse = sectors.stream().map(sector->this.modelMapperService.forResponse().map(sector, GetAllSectorResponse.class)).collect(Collectors.toList());
		
		return sectorResponse;
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
