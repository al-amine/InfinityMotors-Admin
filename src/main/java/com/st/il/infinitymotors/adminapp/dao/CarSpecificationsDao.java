package com.st.il.infinitymotors.adminapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.il.infinitymotors.adminapp.model.CarSpecifications;


@Repository
public interface CarSpecificationsDao extends JpaRepository<CarSpecifications, Integer> {

}
