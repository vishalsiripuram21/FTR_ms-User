package com.FTRUserMS.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.FTRUserMS.CustomExceptions.CustomException;
import com.FTRUserMS.CustomExceptions.USER_ALREADY_EXIST;
import com.FTRUserMS.CustomExceptions.USER_NOT_FOUND;
import com.FTRUserMS.DTO.LoginDTO;
import com.FTRUserMS.DTO.UserProfileDTO;
import com.FTRUserMS.Entity.Ftr_User;
import com.FTRUserMS.Repository.Ftr_UserRepository;

@Service
@Transactional
@PropertySource("classpath:ValidationMessages.properties")
public class UserProfileService {

	@Autowired
	public Ftr_UserRepository userRepository;

	@Value("${user.alreadyexists}")
	public String useralreadyExists;

	@Value("${user.notFound}")
	public String usernotFound;

	@Value("${user.update.success}")
	public String userUpdateSuccess;

	@Value("${user.delete.success}")
	public String userDeleteSuccess;
	
	@Value("${user.update.fail}")
	public String userUpdateFail;
	
	@Value("${user.login.failure}")
	public String loginFailure;
	
	public UserProfileDTO createUser(UserProfileDTO dto) throws USER_ALREADY_EXIST {
		Ftr_User existingUser = userRepository.findByPersonIdentificationNumber(dto.getPersonalIdentificationNumber());
		if (existingUser != null) {
			throw new USER_ALREADY_EXIST(useralreadyExists);
		}
		Ftr_User newUser = new Ftr_User(dto);
		Ftr_User savedUserObject = userRepository.save(newUser);
		dto.setUserId(savedUserObject.getUserId());
		return dto;
	}

	public UserProfileDTO getUser(Integer userId) throws USER_NOT_FOUND {
		Optional<Ftr_User> userObj = userRepository.findById(userId);
		if (!userObj.isPresent()) {
			throw new USER_NOT_FOUND(usernotFound);
		}
		UserProfileDTO userDto = new UserProfileDTO(userObj.get());
		return userDto;

	}

	public String updateUserProfile(Integer userId, UserProfileDTO dto) throws USER_NOT_FOUND, CustomException {

		Boolean flag = false;
		Optional<Ftr_User> userObj = userRepository.findById(userId);
		if (!userObj.isPresent()) {
			throw new USER_NOT_FOUND(usernotFound);
		}
		if (dto.getMobileNumber() != null){
			flag = true;
			userObj.get().setMobileNumber(dto.getMobileNumber());
			userRepository.save(userObj.get());
		}
		if(dto.getOfficeAddress()!=null) {
			flag = true;
			userObj.get().setOfficeAddress(dto.getOfficeAddress());;
			userRepository.save(userObj.get());
		}
		if(dto.getPermanentAddress()!=null) {
			flag = true;
			userObj.get().setPermanentAddress(dto.getPermanentAddress());
			userRepository.save(userObj.get());
		}
		if(!flag)
			throw new CustomException(userUpdateFail);
		String response = "Success {\n message : \""+ userUpdateSuccess + userObj.get().getUserId()+"\"\n}";
		return userUpdateSuccess + userObj.get().getUserId();
	}

	public String deleteUser(Integer userId) throws USER_NOT_FOUND {
		Optional<Ftr_User> userObj = userRepository.findById(userId);
		if (!userObj.isPresent()) {
			throw new USER_NOT_FOUND(usernotFound);
		}
		userRepository.deleteById(userId);
		return userDeleteSuccess + userObj.get().getUserId();
	}
	
	public LoginDTO login(LoginDTO logindto) throws CustomException {
		Ftr_User ftrObj = userRepository.findByIdAndPassword(logindto.getUserId(),logindto.getPassword());
		if(ftrObj == null) {
			System.err.println("hero");
			throw new CustomException(loginFailure);
		}
		return logindto;
	}

}
