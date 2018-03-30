package com.kurita.ass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurita.ass.dao.UnitDAO;
import com.kurita.ass.model.Unit;
import com.kurita.ass.service.UnitService;

@Service
public class UnitServiceImpl implements UnitService{
	@Autowired
	private UnitDAO unitDAO;
	//add 
	@Override
	public Unit add(Unit obj) {
		Unit units=new Unit(obj.getUnit());
		if(unitDAO.save(units) != null)
			return units;
		else
			return null;
	}
	//update
	@Override
	public Unit update(Unit obj) {
		Unit units=new Unit(obj.getUnit());
		units.setIdunit(obj.getIdunit());
		if(unitDAO.save(units)!=null)
			return units;
		else
			return null;
	}
	//delete
	@Override
	public boolean delete(int id) {
		if(unitDAO.existsById(id)) {
			unitDAO.deleteById(id);
			return true;
		}
		return false;
	}
	//view 
	@Override
	public List<Unit> getAll(){
		List<Unit> listof=unitDAO.findAll();
		if(listof.isEmpty())
			return null;
		return listof;
	}
	//view 1
	@Override
	public Unit getId(int id) {
		if(unitDAO.existsById(id))
			return unitDAO.getOne(id);
		return null;
	}
}
