package com.kurita.ass.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kurita.ass.model.Meter;
@Repository
public interface MeterDAO extends JpaRepository<Meter,Integer>{
	Meter findByIdmeter(int id);
}
