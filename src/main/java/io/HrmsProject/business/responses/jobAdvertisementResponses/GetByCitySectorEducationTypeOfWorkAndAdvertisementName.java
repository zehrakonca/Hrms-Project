package io.HrmsProject.business.responses.jobAdvertisementResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCitySectorEducationTypeOfWorkAndAdvertisementName {

	private int cityId;
	private int sectorId;
	private int educationTypeId;
	private int typeOfWork;
}
