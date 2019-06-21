package com.st.il.infinitymotors.adminapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.st.il.infinitymotors.adminapp.model.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
	
	@Query(
	        value = "SELECT * FROM tbl_order NATURAL JOIN tbl_user u WHERE u.userId = :userId", 
	        nativeQuery=true
	    )
	public List<Order> findAllByUser(@Param("userId") Integer userId);
}
