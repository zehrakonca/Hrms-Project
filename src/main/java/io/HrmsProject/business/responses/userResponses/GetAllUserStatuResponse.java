package io.HrmsProject.business.responses.userResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUserStatuResponse {
	private int id;
	private String typeName;

}
