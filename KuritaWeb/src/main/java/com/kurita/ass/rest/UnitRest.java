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

import com.kurita.ass.model.Unit;
import com.kurita.ass.service.UnitService;



@RestController
@RequestMapping("/kurita")
public class UnitRest {
	@Autowired
    private UnitService unitService;
    //view all
    @RequestMapping(value = "/unit/", method = RequestMethod.GET)
    public ResponseEntity<List<Unit>> listAllUnit() {
        List<Unit> units = unitService.getAll();
        if (units.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Unit>>(units, HttpStatus.OK);
    }
    //view 1 entity
    @RequestMapping(value = "/unit/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUnit(@PathVariable("id") int id) {
    	Unit units = unitService.getId(id);
        return new ResponseEntity<Unit>(units, HttpStatus.OK);
    }
    //creat
    @RequestMapping(value = "/unit/",method = RequestMethod.POST)
    public ResponseEntity<?> creatUnit(Unit unit, UriComponentsBuilder ucBuilder) throws ParseException {
    	Unit units=unitService.add(unit); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/kurita/unit/{id}").buildAndExpand(units.getIdunit()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    //update
    @RequestMapping(value = "/unit/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUnit(Unit unit) throws ParseException{
    	Unit currentUnit=unitService.update(unit);
        return new ResponseEntity<Unit>(currentUnit, HttpStatus.OK);
    }
    //delete 1 entity
    @RequestMapping(value = "/unit/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUnit(@PathVariable("id") int id) {
        if(unitService.delete(id)) {
        	
        	return new ResponseEntity<Unit>(HttpStatus.NO_CONTENT);
        }
        else
        	return new ResponseEntity("no delete  with id {} khong co.",HttpStatus.NOT_FOUND);
    }
}
