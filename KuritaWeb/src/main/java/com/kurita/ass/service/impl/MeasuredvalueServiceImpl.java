package com.kurita.ass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurita.ass.dao.MeasuredvalueDAO;
import com.kurita.ass.model.Measuredvalue;
import com.kurita.ass.service.MeasuredvalueService;



@Service
public class MeasuredvalueServiceImpl implements MeasuredvalueService {
	@Autowired
	private MeasuredvalueDAO measuredvalueDAO;
	//add 
	@Override
	public Measuredvalue add(Measuredvalue obj) {
		Measuredvalue measuredvalues=new Measuredvalue(obj.getDatetime(),obj.getValue(),obj.getValuetype());
		if(measuredvalueDAO.save(measuredvalues) != null)
			return measuredvalues;
		else
			return null;
	}
	//update
	@Override
	public Measuredvalue update(Measuredvalue obj) {
		Measuredvalue measuredvalues=new Measuredvalue(obj.getDatetime(),obj.getValue(),obj.getValuetype());
		measuredvalues.setIdvalue(obj.getIdvalue());
		if(measuredvalueDAO.save(measuredvalues)!=null)
			return measuredvalues;
		else
			return null;
	}
	//delete
	@Override
	public boolean delete(int id) {
		if(measuredvalueDAO.existsById(id)) {
			measuredvalueDAO.deleteById(id);
			return true;
		}
		return false;
	}
	//view 
	@Override
	public List<Measuredvalue> getAll(){
		List<Measuredvalue> listof=measuredvalueDAO.findAll();
		if(listof.isEmpty())
			return null;
		return listof;
	}
	//view 1
	@Override
	public Measuredvalue getId(int id) {
		if(measuredvalueDAO.existsById(id))
			return measuredvalueDAO.getOne(id);
		return null;
	}
}
