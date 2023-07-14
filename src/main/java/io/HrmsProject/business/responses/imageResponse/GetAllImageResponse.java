package io.HrmsProject.business.responses.imageResponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllImageResponse {
	
	private int id;
	private String url;
	private LocalDate createdDate;
	private int userId;
}
