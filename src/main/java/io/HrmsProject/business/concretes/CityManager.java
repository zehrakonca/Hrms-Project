package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.CityService;
import io.HrmsProject.business.requests.cityRequests.CreateCityRequests;
import io.HrmsProject.business.requests.cityRequests.UpdateCityRequests;
import io.HrmsProject.business.responses.cityResponse.GetAllCityResponse;
import io.HrmsProject.business.responses.cityResponse.GetByIdCityResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.CityDao;
import io.HrmsProject.entities.concretes.City;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityManager implements CityService{
	
	private CityDao cityDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateCityRequests createEntity) throws Exception {
		City city = this.modelMapperService.forRequest().map(createEntity, City.class);
		this.cityDao.save(city);
		return new SuccessResult("city added.");
	}
	@Override
	public Result update(UpdateCityRequests updateEntity) {
		City city = this.modelMapperService.forRequest().map(updateEntity, City.class);
		this.cityDao.save(city);
		
		return new SuccessResult("city updated.");
	}
	@Override
	public Result delete(int id) {
		this.cityDao.deleteById(id);
		return new SuccessResult("city deleted.");
	}
	@Override
	public DataResult<List<GetAllCityResponse>> getAll() {
		List<City> cities = cityDao.findAll();
		
		List<GetAllCityResponse> cityResponse = cities.stream().map(city->this.modelMapperService.forResponse().map(city, GetAllCityResponse.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllCityResponse>>(cityResponse);
	}
	@Override
	public GetByIdCityResponse getById(int id) {
		City city = this.cityDao.findById(id);
		
		GetByIdCityResponse response = this.modelMapperService.forResponse().map(city, GetByIdCityResponse.class);
		return response;
	}

}
