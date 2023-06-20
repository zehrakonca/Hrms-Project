package io.HrmsProject.business.requests.favoriteJobAdvertisementRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFavoriteJobAdvertisementRequest {
	
	private int jobSeekerId;
	private int jobAdvertisementId;
}
