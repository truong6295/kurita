package com.kurita.ass.service;

import java.util.List;

import com.kurita.ass.model.User;

public interface UserService {
	//add 
	 User add(User obj);
	//update
	 User update(User obj);
	//delete
	 boolean delete(int id);
	//view 
	 List<User> getAll();
	//view 1
	 User getId(int id) ;
}
