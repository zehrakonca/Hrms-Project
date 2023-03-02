package io.HrmsProject.business.responses.cityResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCityResponse {
	
	private int cityId;
	private String city;

}
