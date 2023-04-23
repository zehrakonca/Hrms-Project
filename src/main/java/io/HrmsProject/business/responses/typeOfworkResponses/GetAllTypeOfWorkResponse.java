package io.HrmsProject.business.responses.typeOfworkResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTypeOfWorkResponse {
	
	private int typeId;
	private String typeName;

}
