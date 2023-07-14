package io.HrmsProject.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.HrmsProject.business.responses.imageResponse.GetAllImageResponse;
import io.HrmsProject.business.responses.imageResponse.GetByIdImageResponse;
import io.HrmsProject.business.responses.imageResponse.GetByUserIdImageResponse;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.Image;

public interface ImageService {

	Result add(Image image, MultipartFile multipartFile);

	Result update(Image image);

	Result delete(int id);

	DataResult<GetByUserIdImageResponse> getByUserId(int userId);

	DataResult<GetByIdImageResponse> getById(int id);

	DataResult<List<GetAllImageResponse>> getAll();

}
