package io.HrmsProject.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.HrmsProject.business.requests.imageRequests.CreateImageRequest;
import io.HrmsProject.business.requests.imageRequests.UpdateImageRequest;
import io.HrmsProject.business.responses.imageResponse.GetAllImageResponse;
import io.HrmsProject.business.responses.imageResponse.GetByIdImageResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;

public interface ImageService {
	
	DataResult<GetByIdImageResponse> getByUserId(int userId);
	
	DataResult<GetByIdImageResponse> getById(int id);
	
	DataResult<List<GetAllImageResponse>> getAll();
	
	Result add(CreateImageRequest createImageRequest, MultipartFile multipartFile);	
	
	Result update(UpdateImageRequest updateImageRequest, MultipartFile multipartFile);
	
	Result delete(int id);	
	
}
