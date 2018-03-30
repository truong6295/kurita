package com.kurita.ass.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kurita.ass.model.Measuredvalue;

@Repository
public interface  MeasuredvalueDAO extends JpaRepository<Measuredvalue, Integer> {
	 Measuredvalue findByidvalue(int idValue);
}
