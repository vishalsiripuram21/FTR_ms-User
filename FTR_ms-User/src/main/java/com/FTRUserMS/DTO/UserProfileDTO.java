package com.FTRUserMS.DTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.FTRUserMS.Entity.Ftr_User;

@Component

@PropertySource("classpath:ValidationMessages.properties")
public class UserProfileDTO {
	private Integer userId;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	

	private String mobileNumber;
	

	private String password;
	

	private String nationality;
	
	
	private String passportNumber;

	private String permanentAddress;
	
	private String officeAddress;
	
	private String personalIdentificationNumber;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}
	public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}
	
	public UserProfileDTO(Ftr_User userObj){
		this.setFirstName(userObj.getFirstName());
		this.setLastName(userObj.getLastName());
		this.setMobileNumber(userObj.getMobileNumber());
		this.setEmailId(userObj.getEmailId());
		this.setNationality(userObj.getNationality());
		this.setOfficeAddress(userObj.getOfficeAddress());
		this.setPassportNumber(userObj.getPassportNumber());
		this.setPassword(userObj.getPassword());
		this.setPermanentAddress(userObj.getPermanentAddress());
		this.setPersonalIdentificationNumber(userObj.getPersonalIdentificationNumber());
		this.setUserId(userObj.getUserId());
	}
	
	public UserProfileDTO( ) {
		// TODO Auto-generated constructor stub
	}

}
