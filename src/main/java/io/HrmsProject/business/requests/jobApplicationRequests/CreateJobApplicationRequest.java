package io.HrmsProject.business.requests.jobApplicationRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobApplicationRequest {

	private int jobSeekerId;
	private int jobAdvertisementId;
	private LocalDate applicationDate;
}
