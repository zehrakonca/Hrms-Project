package io.HrmsProject.business.concretes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.HrmsProject.business.abstracts.ImageService;
import io.HrmsProject.business.adapters.cloudinary.CloudStorageService;
import io.HrmsProject.business.responses.imageResponse.GetAllImageResponse;
import io.HrmsProject.business.responses.imageResponse.GetByIdImageResponse;
import io.HrmsProject.business.responses.imageResponse.GetByUserIdImageResponse;
import io.HrmsProject.core.dataAccess.UserDao;
import io.HrmsProject.core.utilities.mappers.ModelMapperService;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.core.utilities.results.SuccessDataResult;
import io.HrmsProject.core.utilities.results.SuccessResult;
import io.HrmsProject.dataAccess.abstracts.ImageDao;
import io.HrmsProject.entities.concretes.Image;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageManager implements ImageService {
	
	private ModelMapperService modelMapperService;
	private ImageDao imageDao;
	private UserDao userDao;
	private CloudStorageService cloudStorageService;
	
	@SuppressWarnings("unchecked")
	@Override
	public Result add(Image image, MultipartFile multipartFile) {
		
		Map<String, String> imageUpload = this.cloudStorageService.uploadImage(multipartFile).getData();
		image.setUrl(imageUpload.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("resim başarıyla eklendi.");
	}

	@Override
	public Result update(Image image) {
		this.imageDao.save(image);
		return new SuccessResult("fotoğraf güncellendi."); 
	}

	@Override
	public Result delete(int id) {
		Image image = this.imageDao.findById(id).get();
		imageDao.deleteById(id);
		return new SuccessResult("image has been deleted.");
	}

	@Override
	public DataResult<List<GetAllImageResponse>> getAll() {
		List<Image> images = this.imageDao.findAll();
		List<GetAllImageResponse> imagesResponses = images.stream().map(image->this.modelMapperService.forResponse().map(image, GetAllImageResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllImageResponse>>(imagesResponses);
	}

	@Override
	public DataResult<GetByUserIdImageResponse> getByUserId(int userId) {
		
		Image image = this.imageDao.findByUser_Id(userId);
		
		GetByUserIdImageResponse response = this.modelMapperService.forResponse().map(image, GetByUserIdImageResponse.class);
		return new SuccessDataResult<GetByUserIdImageResponse>(response);
		
	}

	@Override
	public DataResult<GetByIdImageResponse> getById(int id) {
Image image = this.imageDao.findById(id).orElseThrow();
		
		GetByIdImageResponse response = this.modelMapperService.forResponse().map(image, GetByIdImageResponse.class);
		return new SuccessDataResult<GetByIdImageResponse>(response);
	}
	

}