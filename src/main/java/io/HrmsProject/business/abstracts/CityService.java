package io.HrmsProject.business.abstracts;

import io.HrmsProject.business.requests.cityRequests.CreateCityRequests;
import io.HrmsProject.business.requests.cityRequests.UpdateCityRequests;
import io.HrmsProject.business.responses.cityResponse.GetAllCityResponse;
import io.HrmsProject.business.responses.cityResponse.GetByIdCityResponse;
import io.HrmsProject.entities.concretes.City;

public interface CityService extends BaseEntityService<City, CreateCityRequests, UpdateCityRequests, GetAllCityResponse,GetByIdCityResponse>{

}
