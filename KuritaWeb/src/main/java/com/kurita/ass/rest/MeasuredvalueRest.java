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

import com.kurita.ass.model.Measuredvalue;
import com.kurita.ass.model.User;
import com.kurita.ass.service.MeasuredvalueService;

@RestController
@RequestMapping("/kurita")
public class MeasuredvalueRest {
	@Autowired
    private MeasuredvalueService measuredvalueService; 
    //view all
    @RequestMapping(value = "/measuredvalue/", method = RequestMethod.GET)
    public ResponseEntity<List<Measuredvalue>> listAllMeasuredvalue() {
        List<Measuredvalue> measuredvalues = measuredvalueService.getAll();
        if (measuredvalues.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Measuredvalue>>(measuredvalues, HttpStatus.OK);
    }
    //view 1 entity
    @RequestMapping(value = "/measuredvalue/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMeasuredvalue(@PathVariable("id") int id) {
    	Measuredvalue measuredvalues = measuredvalueService.getId(id);
        return new ResponseEntity<Measuredvalue>(measuredvalues, HttpStatus.OK);
    }
    //creat
    @RequestMapping(value = "/measuredvalue/",method = RequestMethod.POST)
    public ResponseEntity<?> creatMeasuredvalue(Measuredvalue measuredvalue, UriComponentsBuilder ucBuilder) throws ParseException {
    	Measuredvalue measuredvalues=measuredvalueService.add(measuredvalue); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/kurita/user/{id}").buildAndExpand(measuredvalues.getIdvalue()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    //update
    @RequestMapping(value = "/measuredvalue/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMeasuredvalue(Measuredvalue measuredvalue) throws ParseException{
    	Measuredvalue currentMeasuredvalue=measuredvalueService.update(measuredvalue);
        return new ResponseEntity<Measuredvalue>(currentMeasuredvalue, HttpStatus.OK);
    }
    //delete 1 entity
    @RequestMapping(value = "/measuredvalue/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMeasuredvalue(@PathVariable("id") int id) {
        if(measuredvalueService.delete(id)) {
        	
        	return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        else
        	return new ResponseEntity("no delete personal with id {} khong co.",HttpStatus.NOT_FOUND);
    }
}
