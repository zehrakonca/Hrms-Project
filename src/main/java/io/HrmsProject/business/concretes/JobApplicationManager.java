package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.HrmsProject.business.abstracts.JobApplicationService;
import io.HrmsProject.business.requests.jobApplicationRequests.CreateJobApplicationRequest;
import io.HrmsProject.business.requests.jobApplicationRequests.UpdateJobApplicationRequest;
import io.HrmsProject.business.responses.jobApplicationResponses.GetAllJobApplicationResponse;
import io.HrmsProject.business.responses.jobApplicationResponses.GetByEmployerIdJobApplicationResponse;
import io.HrmsProject.business.responses.jobApplicationResponses.GetByIdJobApplicationResponse;
import io.HrmsProject.business.responses.jobApplicationResponses.GetByJobSeekerIdJobApplicationResponse;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.EmployerDao;
import io.HrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import io.HrmsProject.dataAccess.abstracts.JobApplicationDao;
import io.HrmsProject.dataAccess.abstracts.JobSeekerDao;
import io.HrmsProject.entities.concretes.JobAdvertisement;
import io.HrmsProject.entities.concretes.JobApplication;
import io.HrmsProject.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobApplicationManager implements JobApplicationService {

	private JobApplicationDao jobApplicationDao;
	private JobSeekerDao jobSeekerDao;
	private EmployerDao employerDao;
	private ModelMapperService modelMapperService;
	private JobAdvertisementDao jobAdvertisementDao;

	@Override
	public Result add(CreateJobApplicationRequest createEntity) throws Exception {
		JobApplication jobApplication = this.modelMapperService.forRequest().map(createEntity, JobApplication.class);
		JobSeeker jobSeeker = this.jobSeekerDao.findById(createEntity.getJobSeekerId());
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(createEntity.getJobAdvertisementId());

		jobApplication.setJobSeeker(jobSeeker);
		jobApplication.setJobAdvertisement(jobAdvertisement);
		jobApplication.setApplicationDate(createEntity.getApplicationDate().atStartOfDay());

		this.jobApplicationDao.save(jobApplication);
		return new SuccessResult("your application has been sent.");

	}

	@Override
	public Result update(UpdateJobApplicationRequest updateEntity) throws Exception {
		JobApplication jobApplication = this.modelMapperService.forRequest().map(updateEntity, JobApplication.class);
		this.jobApplicationDao.save(jobApplication);
		return new SuccessResult("your job application has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.jobApplicationDao.deleteById(id);
		return new SuccessResult("your job application has been deleted.");
	}

	@Override
	public DataResult<List<GetAllJobApplicationResponse>> getAll() {
		List<JobApplication> jobApplications = this.jobApplicationDao.findAll();
		List<GetAllJobApplicationResponse> jobApplicationResponses = jobApplications.stream()
				.map(jobApplication -> this.modelMapperService.forResponse().map(jobApplication,
						GetAllJobApplicationResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllJobApplicationResponse>>(jobApplicationResponses);
	}

	@Override
	public DataResult<GetByIdJobApplicationResponse> getById(int id) {
		JobApplication jobApplication = this.jobApplicationDao.findById(id);

		GetByIdJobApplicationResponse response = this.modelMapperService.forResponse().map(jobApplication,
				GetByIdJobApplicationResponse.class);
		return new SuccessDataResult<GetByIdJobApplicationResponse>(response);
	}

	@Override
	public DataResult<List<GetByEmployerIdJobApplicationResponse>> getByEmployerId(int employerId) {
		List<JobApplication> jobApplications = this.jobApplicationDao.findAll();
		List<GetByEmployerIdJobApplicationResponse> jobApplicationResponses = jobApplications.stream()
				.map(jobApplication -> this.modelMapperService.forResponse().map(jobApplication,
						GetByEmployerIdJobApplicationResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetByEmployerIdJobApplicationResponse>>(jobApplicationResponses);
	}

	@Override
	public DataResult<List<GetByJobSeekerIdJobApplicationResponse>> getByJobSeekerId(int jobSeeker) {
		List<JobApplication> jobApplications = this.jobApplicationDao.findAll();
		List<GetByJobSeekerIdJobApplicationResponse> jobApplicationResponses = jobApplications.stream()
				.map(jobApplication -> this.modelMapperService.forResponse().map(jobApplication,
						GetByJobSeekerIdJobApplicationResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetByJobSeekerIdJobApplicationResponse>>(jobApplicationResponses);
	}

}
