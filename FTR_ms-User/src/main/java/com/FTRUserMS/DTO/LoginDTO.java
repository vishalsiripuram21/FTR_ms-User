package com.FTRUserMS.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@PropertySource("classpath:ValidationMessages.properties")
public class LoginDTO {
	
	@NotNull(message = "{input.parameter.missing}")
	private Integer userId;
	
	@NotBlank(message = "{input.parameter.missing}")
	private String password;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
