package io.HrmsProject.business.requests.typeOfWorkRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTypeOfWorkRequest {

	private String typeName;
}
