package com.st.il.infinitymotors.adminapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.st.il.infinitymotors.adminapp.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query(
	        value = "SELECT * FROM tbl_user u WHERE u.username = :username", 
	        nativeQuery=true
	    )
	public Optional<User> findByUsername(@Param("username") String username);
	
}
