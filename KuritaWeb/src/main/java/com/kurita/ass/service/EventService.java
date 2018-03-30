package com.kurita.ass.service;

import java.util.List;

import com.kurita.ass.model.Event;

public interface EventService {

	 Event add(Event obj);
	//update
	 Event update(Event obj);
	//delete
	 boolean delete(int id);
	//view 
	 List<Event> getAll();
	//view 1
	 Event getId(int id);
}
