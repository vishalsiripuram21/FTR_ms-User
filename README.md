# FTR_ms-User

======================= Consul Cloud Integration ==================

Creating Default Folder
	
	==> Inside Key/Values
	==> create "config" Folder
	==> Inside "config" Create Folder application/data

	application/data add Below code
  spring:
 	 datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
  	username: {DataBaseUserName}
  	password: {DataBasePassword}
   jpa:
 	  hibernate:
   	 ddl-auto: update
  	show-sql: true

Creating User Specific MicroService Folder

	==> Inside Key/Values/config Create "FTR_ms-User/data"

	Add Below data inside "FTR_ms-User/data"

	spring:
 	 datasource:
    url: jdbc:mysql://localhost:3306/freight_transport_region_user
	
