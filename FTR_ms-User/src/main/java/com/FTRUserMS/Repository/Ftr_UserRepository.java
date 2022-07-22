package com.FTRUserMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FTRUserMS.DTO.LoginDTO;
import com.FTRUserMS.Entity.Ftr_User;

@Repository
public interface Ftr_UserRepository extends JpaRepository<Ftr_User, Integer>{
	
	@Query("select user from Ftr_User user where user.personalIdentificationNumber=?1")
	public Ftr_User findByPersonIdentificationNumber(String personalIdentificationNumber);
	
	@Query("select user from Ftr_User user where user.userId=?1 and user.password=?2 ")
	public Ftr_User findByIdAndPassword(Integer userId,String password);

}
