package io.HrmsProject.business.requests.jobRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateJobRequests {

	private int id;
	private String job;
	private int sector;
}
