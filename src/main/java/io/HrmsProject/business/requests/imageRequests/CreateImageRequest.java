package io.HrmsProject.business.requests.imageRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateImageRequest {
	
	private String url;
	private int user;

}
