package io.HrmsProject.business.responses.imageResponse;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllImageResponse {
	
	private int userId;
	
	private MultipartFile multipartFile;

}