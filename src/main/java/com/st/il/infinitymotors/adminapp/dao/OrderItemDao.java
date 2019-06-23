package com.st.il.infinitymotors.adminapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.il.infinitymotors.adminapp.model.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {

}
