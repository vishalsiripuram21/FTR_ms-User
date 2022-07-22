package com.FTRUserMS.Entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import com.FTRUserMS.DTO.UserProfileDTO;

@Entity
@Validated
@PropertySource("classpath:ValidationMessages.properties")
public class  Ftr_User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotBlank(message = "{user.firstName.must}")
	@Length(max = 20,message = "{user.firstName.invalid}")
	private String firstName;
	
	@NotBlank(message = "{user.lastName.must}")
	@Length(max = 20,message = "{user.lastName.invalid}")
	private String lastName;
	
	@NotBlank(message = "{user.email.must}")
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+[.]{1}[a-zA-Z]+$",message = "{user.email.invalid}")
	private String emailId;
	
	@NotBlank(message = "{user.phone.must}")
	@Pattern(regexp = "[0-9]{10}",message = "{user.phone.invalid}")
	private String mobileNumber;
	
	@NotBlank(message = "{user.password.must}")
	@Length(min = 7,max = 15,message = "{user.password.invalidsize}")
	@Pattern(regexp = "^[A-Za-z0-9@#$%&^!]*[@#$%&!][A-Za-z0-9@#$%&!]*$",message = "{user.password.invalid}")
	private String password;
	
	@NotBlank(message = "{user.nationality.must}")
	private String nationality;
	
	@NotBlank(message = "{user.passportNumber.must}")
	@Length(min = 7,max = 12,message = "{user.passportNumber.invalid}")
	private String passportNumber;
	
	@NotBlank(message = "{user.permanentAddress.must}")
	@Length(max = 200,message = "{user.permanentAddress.invalid}")
	private String permanentAddress;
	
	@NotBlank(message = "{user.officeAddress.must}")
	@Length(max = 200,message = "{user.officeAddress.invalid }")
	private String officeAddress;
	
	@NotBlank(message = "{user.personalIdentificationNumber.must}")
	@Pattern(regexp = "[0-9]{12}",message = "{user.personalIdentificationNumber.invalid}")
	private String personalIdentificationNumber;
	
	public Integer getUserId() {
		return userId;
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
	
	public Ftr_User(UserProfileDTO dto) {
		this.setEmailId(dto.getEmailId());
		this.setFirstName(dto.getFirstName());
		this.setLastName(dto.getLastName());
		this.setMobileNumber(dto.getMobileNumber());
		this.setNationality(dto.getNationality());
		this.setOfficeAddress(dto.getOfficeAddress());
		this.setPassportNumber(dto.getPassportNumber());
		this.setPassword(dto.getPassword());
		this.setPermanentAddress(dto.getPermanentAddress());
		this.setPersonalIdentificationNumber(dto.getPersonalIdentificationNumber());
	}
	public Ftr_User() {
		// TODO Auto-generated constructor stub
	}

}
