package com.kurita.ass.service;

import java.util.List;

import com.kurita.ass.model.Type;


public interface TypeService {
	//add 
	 Type add(Type obj);
	//update
	public Type update(Type obj);
	//delete
	 boolean delete(int id) ;
	//view 
	 List<Type> getAll();
	//view 1
	 Type getId(int id);
}
