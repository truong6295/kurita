package com.kurita.ass.rest;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.kurita.ass.model.Event;
import com.kurita.ass.service.EventService;

@RestController
@RequestMapping("/kurita")
public class EventRest {
	@Autowired
    private EventService eventService;
    //view all
    @RequestMapping(value = "/event/", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> listAllEvent() {
        List<Event> events = eventService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }
    //view 1 entity
    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEvent(@PathVariable("id") int id) {
    	Event events = eventService.getId(id);
        return new ResponseEntity<Event>(events, HttpStatus.OK);
    }
    //creat
    @RequestMapping(value = "/event/",method = RequestMethod.POST)
    public ResponseEntity<?> creatAssignment(Event event, UriComponentsBuilder ucBuilder) throws ParseException {
        Event events=eventService.add(event);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/kurita/event/{id}").buildAndExpand(events.getIdevent()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    //update
    @RequestMapping(value = "/event/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEvent(Event event) throws ParseException{
        Event currentEvent=eventService.update(event);
        return new ResponseEntity<Event>(currentEvent, HttpStatus.OK);
    }
    //delete 1 entity
    @RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEvent(@PathVariable("id") int id) {
        if(eventService.delete(id)) {
        	
        	return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
        }
        else
        	return new ResponseEntity("no delete personal with id {} khong co.",HttpStatus.NOT_FOUND);
    }
}
