package com.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.Registration;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration,Long>{

//	Optional<Registration> findByEmail(String email);
//	Optional<Registration> findByMobile(String mobile);
	
	@Query("select r from Registration r where r.mobile=:mobile")
	Registration findByMobile(@Param("mobile") String mobile);
	
	
//	Iterable<Registration> findByEmailAndMobile(String email,String mobile);
	
	@Query("select r from Registration r where r.email=:email and r.mobile=:mobile")
	Optional<Registration> findByEmailAndMobile(@Param("email") String email,@Param("mobile") String mobile);
	
	@Query("select r from Registration r where r.email=:email or r.mobile=:mobile")
	List<Registration> findByEmailOrMobile(@Param("email") String email, @Param("mobile") String mobile);
	
	@Query("select r from Registration r where r.email=:x")
	Registration findRegByEmail(@Param("x") String emailId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
