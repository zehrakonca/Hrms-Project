package io.HrmsProject.business.requests.sectorRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSectorRequests {
	
	private int id;
	private String sector;
}
