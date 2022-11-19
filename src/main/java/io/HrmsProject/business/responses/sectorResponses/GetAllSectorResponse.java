package io.HrmsProject.business.responses.sectorResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSectorResponse {
	
	private int id;
	private String sector;

}
