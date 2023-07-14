package io.HrmsProject.business.responses.imageResponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByUserIdImageResponse {
	
	private int imageId;
	private String url;
	private LocalDate createdDate;

}
