package com.kurita.ass.service;

import java.util.List;

import com.kurita.ass.model.Measuredvalue;


public interface MeasuredvalueService {
	//add 
	 Measuredvalue add(Measuredvalue obj);
	//update
	 Measuredvalue update(Measuredvalue obj);
	//delete
	 boolean delete(int id);
	//view 
	 List<Measuredvalue> getAll();
	//view 1
	 Measuredvalue getId(int id);
}
