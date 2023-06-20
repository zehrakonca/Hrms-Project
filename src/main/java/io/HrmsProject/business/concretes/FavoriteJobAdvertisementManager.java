package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.FavoriteJobAdvertisementService;
import io.HrmsProject.business.requests.favoriteJobAdvertisementRequests.CreateFavoriteJobAdvertisementRequest;
import io.HrmsProject.business.requests.favoriteJobAdvertisementRequests.UpdateFavoriteJobAdvertisementRequest;
import io.HrmsProject.business.responses.favoriteJobAdvertisementResponses.GetAllFavoriteJobAdvertisementResponse;
import io.HrmsProject.business.responses.favoriteJobAdvertisementResponses.GetByIdFavoriteJobAdvertisementResponse;
import io.HrmsProject.business.responses.favoriteJobAdvertisementResponses.GetByJobSeekerIdFavoriteJobAdvertisementResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.CityDao;
import io.HrmsProject.dataAccess.abstracts.EmployerDao;
import io.HrmsProject.dataAccess.abstracts.FavoriteJobAdvertisementDao;
import io.HrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import io.HrmsProject.dataAccess.abstracts.JobDao;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.entities.concretes.FavoriteJobAdvertisement;
import io.HrmsProject.entities.concretes.JobAdvertisement;
import io.HrmsProject.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FavoriteJobAdvertisementManager implements FavoriteJobAdvertisementService {
	
	private FavoriteJobAdvertisementDao favoriteJobAdvertisementDao;
	private JobAdvertisementDao jobAdvertisementDao;
	private JobSeekerDao jobSeekerDao;
	private EmployerDao employerDao;
	private JobDao jobDao;
	private CityDao cityDao;
	private ModelMapperService modelMapperService;
	
	@Override
	public Result add(CreateFavoriteJobAdvertisementRequest createEntity) throws Exception {
		FavoriteJobAdvertisement favoriteJobAdvertisement =this.modelMapperService.forRequest().map(createEntity, FavoriteJobAdvertisement.class);
		
		JobSeeker jobSeeker = this.jobSeekerDao.findById(createEntity.getJobSeekerId());
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(createEntity.getJobAdvertisementId());
		
		favoriteJobAdvertisement.setJobSeeker(jobSeeker);
		favoriteJobAdvertisement.setJobAdvertisement(jobAdvertisement);
		
		this.favoriteJobAdvertisementDao.save(favoriteJobAdvertisement);
		return new SuccessResult("advertisement has been added in your favorite list.");
				}

	@Override
	public Result update(UpdateFavoriteJobAdvertisementRequest updateEntity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		this.favoriteJobAdvertisementDao.deleteById(id);
		return new SuccessResult("advertisement has been deleted in your favorite list.");
	}

	@Override
	public DataResult<List<GetAllFavoriteJobAdvertisementResponse>> getAll() {
		List<FavoriteJobAdvertisement> favoriteJobAdvertisements = this.favoriteJobAdvertisementDao.findAll();
		List<GetAllFavoriteJobAdvertisementResponse> favoriteJobAdvertisementsResponses = favoriteJobAdvertisements.stream().map(favoriteJobAdvertisement->this.modelMapperService.forResponse().map(favoriteJobAdvertisements, GetAllFavoriteJobAdvertisementResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllFavoriteJobAdvertisementResponse>>(favoriteJobAdvertisementsResponses);
	}

	@Override
	public DataResult<GetByIdFavoriteJobAdvertisementResponse> getById(int id) {
		FavoriteJobAdvertisement favoriteJobAdvertisement = this.favoriteJobAdvertisementDao.findById(id);
		GetByIdFavoriteJobAdvertisementResponse response = this.modelMapperService.forResponse().map(favoriteJobAdvertisement, GetByIdFavoriteJobAdvertisementResponse.class);
		
		return new SuccessDataResult<GetByIdFavoriteJobAdvertisementResponse>(response);
	}

	@Override
	public DataResult<List<GetByJobSeekerIdFavoriteJobAdvertisementResponse>> getByJobSeeker_Id(int jobSeekerId) {
		List<FavoriteJobAdvertisement> favoriteJobAdvertisements = this.favoriteJobAdvertisementDao.getByJobSeeker_Id(jobSeekerId);
		List<GetByJobSeekerIdFavoriteJobAdvertisementResponse> favoriteJobAdvertisementsResponses = favoriteJobAdvertisements.stream().map(favoriteJobAdvertisement->this.modelMapperService.forResponse().map(favoriteJobAdvertisement, GetByJobSeekerIdFavoriteJobAdvertisementResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetByJobSeekerIdFavoriteJobAdvertisementResponse>>(favoriteJobAdvertisementsResponses);
	}

}
