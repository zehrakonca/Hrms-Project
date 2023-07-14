package io.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.HrmsProject.business.abstracts.ImageService;
import io.HrmsProject.business.abstracts.UserService;
import io.HrmsProject.business.responses.imageResponse.GetAllImageResponse;
import io.HrmsProject.business.responses.imageResponse.GetByIdImageResponse;
import io.HrmsProject.business.responses.imageResponse.GetByUserIdImageResponse;
import io.HrmsProject.core.entities.User;
import io.HrmsProject.core.utilities.results.DataResult;
import io.HrmsProject.core.utilities.results.Result;
import io.HrmsProject.entities.concretes.Image;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {

	private ImageService imageService;
	private UserService userService;
	
	@Autowired
	public ImagesController(ImageService imageService, UserService userService) {
		super();
		this.imageService = imageService;
		this.userService = userService;
	}
	
	@PostMapping("add")
	public Result add (@RequestParam(value="userId") int userId, @RequestParam(value="imageFile") MultipartFile imageFile)
	{
		User user = this.userService.getById(userId);
		Image image = new Image();
		image.setUser(user);
		return this.imageService.add(image, imageFile);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam() Image image) {
		return ResponseEntity.ok(imageService.update(image));
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.imageService.delete(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<GetAllImageResponse>> getAll(){
		return imageService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<GetByIdImageResponse> getById(@RequestParam() int id){
		return imageService.getById(id);
	}
	
	@GetMapping("/getByUserId")
	public DataResult<GetByUserIdImageResponse> getByUserId(@RequestParam() int id){
		return imageService.getByUserId(id);
	}
	
	
}
