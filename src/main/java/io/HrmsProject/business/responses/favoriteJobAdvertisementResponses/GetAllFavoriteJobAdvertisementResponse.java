package io.HrmsProject.business.responses.favoriteJobAdvertisementResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllFavoriteJobAdvertisementResponse {
	
	private int id;
	private int jobSeekerId;
	private String companyName;
	private String jobName;
	private String cityName;
	private String advertisementName;

}
