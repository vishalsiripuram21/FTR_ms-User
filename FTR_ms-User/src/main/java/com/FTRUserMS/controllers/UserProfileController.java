package com.FTRUserMS.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FTRUserMS.CustomExceptions.CustomException;
import com.FTRUserMS.CustomExceptions.USER_ALREADY_EXIST;
import com.FTRUserMS.CustomExceptions.USER_NOT_FOUND;
import com.FTRUserMS.DTO.LoginDTO;
import com.FTRUserMS.DTO.UserProfileDTO;
import com.FTRUserMS.service.UserProfileService;

@RestController
@CrossOrigin
@RequestMapping("/ftr/userProfile")
public class UserProfileController {

	@Autowired
	public UserProfileService userService;
	
	@Autowired UserProfileDTO userProfileDtoObj;
	
	@Value("${user.login.success}")
	public String loginsuccess;
	
	@PostMapping
	public ResponseEntity<UserProfileDTO> createUser(@RequestBody @Valid  UserProfileDTO dto) throws USER_ALREADY_EXIST {
		return new ResponseEntity<>(userService.createUser(dto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserProfileDTO> getUser(@PathVariable("userId") Integer userId) throws USER_NOT_FOUND{
		return new ResponseEntity<>(userService.getUser(userId),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<String> updateUserProfile(@PathVariable("userId") Integer userId,@RequestBody @Valid UserProfileDTO dto) throws USER_NOT_FOUND, CustomException{
		return new ResponseEntity<>(userService.updateUserProfile(userId,dto),HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId) throws USER_NOT_FOUND{
		return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody @Valid LoginDTO logindto) throws CustomException{
		String response = "Success:{\n message:\"" + loginsuccess+"\"\n}";
		userService.login(logindto);
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}
	
	
}
