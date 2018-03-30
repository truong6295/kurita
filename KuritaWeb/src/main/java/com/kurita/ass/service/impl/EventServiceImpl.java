package com.kurita.ass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurita.ass.dao.EventDAO;
import com.kurita.ass.model.Event;
import com.kurita.ass.service.EventService;



@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private EventDAO eventDAO;
	//add 
	@Override
	public Event add(Event obj) {
		Event events=new Event(obj.getDescription(), obj.getRelaterobject());
		if(eventDAO.save(events) != null)
			return events;
		else
			return null;
	}
	//update
	@Override
	public Event update(Event obj) {
		Event events=new Event(obj.getDescription(),obj.getRelaterobject()); 
		events.setIdevent(obj.getIdevent());
		if(eventDAO.save(events)!=null)
			return events;
		else
			return null;
	}
	//delete
	@Override
	public boolean delete(int id) {
		if(eventDAO.existsById(id)) {
			eventDAO.deleteById(id);
			return true;
		}
		return false;
	}
	//view 
	@Override
	public List<Event> getAll(){
		List<Event> listof=eventDAO.findAll();
		if(listof.isEmpty())
			return null;
		return listof;
	}
	//view 1
	@Override
	public Event getId(int id) {
		if(eventDAO.existsById(id))
			return eventDAO.getOne(id);
		return null;
	}
}
