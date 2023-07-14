package io.HrmsProject.business.requests.imageRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateImageRequest {
	
	private int id;
	private String url;
	private LocalDate createdDate;
	private int userId;

}
