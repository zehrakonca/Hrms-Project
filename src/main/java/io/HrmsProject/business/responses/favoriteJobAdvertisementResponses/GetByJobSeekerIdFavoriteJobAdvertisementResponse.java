package io.HrmsProject.business.responses.favoriteJobAdvertisementResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByJobSeekerIdFavoriteJobAdvertisementResponse {
	
	private int id;
	private int jobSeekerId;
	private int advertisementId;
	private String advertisementName;
	private String companyName;
	private String city;
}
