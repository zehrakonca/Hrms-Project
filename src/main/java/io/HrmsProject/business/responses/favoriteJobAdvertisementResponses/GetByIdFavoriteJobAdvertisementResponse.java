package io.HrmsProject.business.responses.favoriteJobAdvertisementResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdFavoriteJobAdvertisementResponse {
	
	private int jobSeekerId;
	private int advertisementId;

}
