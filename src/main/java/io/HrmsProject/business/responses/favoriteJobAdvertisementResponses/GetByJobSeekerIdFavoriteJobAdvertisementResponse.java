package io.HrmsProject.business.responses.favoriteJobAdvertisementResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByJobSeekerIdFavoriteJobAdvertisementResponse {

	private int jobSeekerId;
	private int jobAdvertisementId;
}
