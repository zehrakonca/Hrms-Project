package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.UserStatuService;
import io.HrmsProject.business.requests.userRequests.CreateUserStatuRequest;
import io.HrmsProject.business.responses.userResponses.GetAllUserStatuResponse;
import io.HrmsProject.entities.concretes.UserStatu;

@RestController
@RequestMapping("/api/usersStatu")
@CrossOrigin
public class UserStatusController {
	private UserStatuService usersStatuService;

	@Autowired
	public UserStatusController(UserStatuService usersStatuService) {
		super();
		this.usersStatuService = usersStatuService;
	}
	
	@GetMapping("/getById")
	public UserStatu getById(int id) {
		return this.usersStatuService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateUserStatuRequest createUserStatuRequest) throws Exception {
		this.usersStatuService.add(createUserStatuRequest);
	}
	
	@GetMapping("/getAll")
	public List<GetAllUserStatuResponse> getAll() {
		return usersStatuService.getAll();
		}
	
	
}
