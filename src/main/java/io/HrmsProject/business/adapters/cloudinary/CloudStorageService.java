package io.HrmsProject.business.adapters.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import io.HrmsProject.core.utilities.results.DataResult;

public interface CloudStorageService {

	@SuppressWarnings("rawtypes")
	DataResult<Map> uploadImage(MultipartFile imageFile);

}
