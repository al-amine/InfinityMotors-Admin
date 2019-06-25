package com.st.il.infinitymotors.adminapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.st.il.infinitymotors.adminapp.model.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {
	
	@Query(
	        value = "SELECT * FROM tbl_orderitem o WHERE o.orderId = :orderId", 
	        nativeQuery=true
	    )
	public List<OrderItem> findAllByOrder(@Param("orderId") Integer orderId);
}
