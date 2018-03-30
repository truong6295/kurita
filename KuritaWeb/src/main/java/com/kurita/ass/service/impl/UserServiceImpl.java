package com.kurita.ass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurita.ass.dao.UserDAO;
import com.kurita.ass.model.User;
import com.kurita.ass.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	//add 
	@Override
	public User add(User obj) {
		User objs= new User(obj.getPass(),obj.getNameUser());
		if( userDAO.save(objs) != null)
			return objs;
		else
			return null;
	}
	//update
	@Override
	public User update(User obj) {
		User users=new User(obj.getPass(),obj.getNameUser());
		users.setIduser(obj.getIduser());
		if(userDAO.save(users)!=null)
			return users;
		else
			return null;
	}
	//delete
	@Override
	public boolean delete(int id) {
		if(userDAO.existsById(id)) {
			userDAO.deleteById(id);
			return true;
		}
		return false;
	}
	//view 
	@Override
	public List<User> getAll(){
		List<User> listof=userDAO.findAll();
		if(listof.isEmpty())
			return null;
		return listof;
	}
	//view 1
	@Override
	public User getId(int id) {
		if(userDAO.existsById(id))
			return userDAO.getOne(id);
		return null;
	}
}
