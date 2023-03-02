package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.SectorService;
import io.HrmsProject.business.requests.sectorRequests.CreateSectorRequests;
import io.HrmsProject.business.requests.sectorRequests.UpdateSectorRequests;
import io.HrmsProject.business.responses.sectorResponses.GetAllSectorResponse;
import io.HrmsProject.business.responses.sectorResponses.GetByIdSectorResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.ErrorResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
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
	public Result add(CreateSectorRequests createSectorRequests) throws Exception {
		Sector sector = this.modelMapperService.forRequest().map(createSectorRequests, Sector.class);
		
		if(sector.getSector()==null || createSectorRequests.getSector().isEmpty()) {
			return new ErrorResult("sector information cannot be blank.");
		}
		else if(isSectorExist(createSectorRequests.getSector())==true) {
			return new ErrorResult("this sector already in list.");
		}
		else {
			this.sectorDao.save(sector);
			return new SuccessResult("sector has been saved.");
		}
		
	}

	@Override
	public Result delete(int id) {
		this.sectorDao.deleteById(id);
		return new SuccessResult("sector has been deleted");
	}

	@Override
	public Result update(UpdateSectorRequests updateSectorRequests) throws Exception{
		Sector sector = this.modelMapperService.forRequest().map(updateSectorRequests, Sector.class);
		
		if(isSectorExist(updateSectorRequests.getSector())) {
			return new ErrorResult("this sector already in list.");
		}
		else {
			sector.setSector(updateSectorRequests.getSector());
			this.sectorDao.save(sector);
			return new SuccessResult("this sector information has been updated");
		}
		
	}

	@Override
	public DataResult<List<GetAllSectorResponse>> getAll() {
		List<Sector> sectors = sectorDao.findAll();
		
		List<GetAllSectorResponse> sectorResponse = sectors.stream().map(sector->this.modelMapperService.forResponse().map(sector, GetAllSectorResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllSectorResponse>>(sectorResponse);
	}

	@Override
	public GetByIdSectorResponse getById(int id) {
		Sector sector = this.sectorDao.findById(id);
		
		GetByIdSectorResponse response = this.modelMapperService.forResponse().map(sector, GetByIdSectorResponse.class);
		return response;
		
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
