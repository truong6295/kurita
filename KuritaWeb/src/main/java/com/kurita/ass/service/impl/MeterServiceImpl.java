package com.kurita.ass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurita.ass.dao.MeterDAO;
import com.kurita.ass.model.Meter;
import com.kurita.ass.service.MeterService;


@Service
public class MeterServiceImpl implements MeterService{
	@Autowired
	private MeterDAO meterDAO;
	//add 
	@Override
	public Meter add(Meter obj) {
		Meter meters=new Meter(obj.getName(),obj.getNetwork());
		if(meterDAO.save(meters) != null)
			return meters;
		else
			return null;
	}
	//update
	@Override
	public Meter update(Meter obj) {
		Meter meters=new Meter(obj.getName(),obj.getNetwork());
		meters.setIdmeter(obj.getIdmeter());
		if(meterDAO.save(meters)!=null)
			return meters;
		else
			return null;
	}
	//delete
	@Override
	public boolean delete(int id) {
		if(meterDAO.existsById(id)) {
			meterDAO.deleteById(id);
			return true;
		}
		return false;
	}
	//view 
	@Override
	public List<Meter> getAll(){
		List<Meter> listof=meterDAO.findAll();
		if(listof.isEmpty())
			return null;
		return listof;
	}
	//view 1
	@Override
	public Meter getId(int id) {
		if(meterDAO.existsById(id))
			return meterDAO.getOne(id);
		return null;
	}
}
