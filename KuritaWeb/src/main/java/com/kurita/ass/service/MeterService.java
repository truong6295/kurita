package com.kurita.ass.service;

import java.util.List;

import com.kurita.ass.model.Meter;

public interface MeterService {
	//add 
	 Meter add(Meter obj) ;
	//update
	 Meter update(Meter obj);
	//delete
	 boolean delete(int id);
	//view 
	 List<Meter> getAll();
	//view 1
	 Meter getId(int id);
}
