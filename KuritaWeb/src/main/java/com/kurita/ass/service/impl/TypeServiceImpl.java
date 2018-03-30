package com.kurita.ass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurita.ass.dao.TypeDAO;
import com.kurita.ass.model.Type;
import com.kurita.ass.service.TypeService;




@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeDAO typeDAO;
	//add 
	@Override
	public Type add(Type obj) {
		Type types=new Type(obj.getAggregation(),obj.getType());
		if(typeDAO.save(types) != null)
			return types;
		else
			return null;
	}
	//update
	@Override
	public Type update(Type obj) {
		Type types=new Type(obj.getAggregation(),obj.getType());
		types.setIdtype(obj.getIdtype());
		if(typeDAO.save(types)!=null)
			return types;
		else
			return null;
	}
	//delete
	@Override
	public boolean delete(int id) {
		if(typeDAO.existsById(id)) {
			typeDAO.deleteById(id);
			return true;
		}
		return false;
	}
	//view 
	@Override
	public List<Type> getAll(){
		List<Type> listof=typeDAO.findAll();
		if(listof.isEmpty())
			return null;
		return listof;
	}
	//view 1
	@Override
	public Type getId(int id) {
		if(typeDAO.existsById(id))
			return typeDAO.getOne(id);
		return null;
	}
}
