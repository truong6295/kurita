package com.kurita.ass.service;

import java.util.List;

import com.kurita.ass.model.Unit;

public interface UnitService {
	//add 
	 Unit add(Unit obj);
	//update
	 Unit update(Unit obj);
	//delete
	 boolean delete(int id) ;
	//view 
	 List<Unit> getAll();
	//view 1
	 Unit getId(int id);
}
