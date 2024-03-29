package io.HrmsProject.business.abstracts;

import java.util.List;

import io.HrmsProject.business.requests.favoriteJobAdvertisementRequests.CreateFavoriteJobAdvertisementRequest;
import io.HrmsProject.business.requests.favoriteJobAdvertisementRequests.UpdateFavoriteJobAdvertisementRequest;
import io.HrmsProject.business.responses.favoriteJobAdvertisementResponses.GetAllFavoriteJobAdvertisementResponse;
import io.HrmsProject.business.responses.favoriteJobAdvertisementResponses.GetByIdFavoriteJobAdvertisementResponse;
import io.HrmsProject.business.responses.favoriteJobAdvertisementResponses.GetByJobSeekerIdFavoriteJobAdvertisementResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.entities.concretes.FavoriteJobAdvertisement;

public interface FavoriteJobAdvertisementService extends BaseEntityService<FavoriteJobAdvertisement, CreateFavoriteJobAdvertisementRequest, UpdateFavoriteJobAdvertisementRequest, GetAllFavoriteJobAdvertisementResponse, GetByIdFavoriteJobAdvertisementResponse>{
	
	DataResult<List<GetByJobSeekerIdFavoriteJobAdvertisementResponse>> getByJobSeeker_Id(int jobSeekerId);
	

}
