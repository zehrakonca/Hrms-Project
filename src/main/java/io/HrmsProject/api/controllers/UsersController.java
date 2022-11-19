package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.HrmsProject.business.abstracts.UserService;
import io.HrmsProject.business.requests.userRequests.CreateUserRequests;
import io.HrmsProject.business.requests.userRequests.UpdateUserRequests;
import io.HrmsProject.business.responses.userResponses.GetAllUserResponses;
import io.HrmsProject.core.entities.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateUserRequests createUserRequests) throws Exception {
		this.userService.add(createUserRequests);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(int id) {
		this.userService.delete(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateUserRequests updateUserRequests, int id) throws Exception {
		this.userService.update(updateUserRequests,id);
	}	
	
	@GetMapping("/getAll")
	public List<GetAllUserResponses> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/getById")
	public User getById(int id) {
		return userService.getById(id);
	}
}
