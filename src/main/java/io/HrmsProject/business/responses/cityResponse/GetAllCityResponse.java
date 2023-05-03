package io.HrmsProject.business.responses.cityResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCityResponse {
	
	private int id;
	private String cityName;

}
