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

import com.kurita.ass.model.Type;
import com.kurita.ass.service.TypeService;



@RestController
@RequestMapping("/kurita")
public class TypeRest {
	@Autowired
    private TypeService typeService;
    //view all
    @RequestMapping(value = "/type/", method = RequestMethod.GET)
    public ResponseEntity<List<Type>> listAllType() {
        List<Type> types = typeService.getAll();
        if (types.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Type>>(types, HttpStatus.OK);
    }
    //view 1 entity
    @RequestMapping(value = "/type/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getType(@PathVariable("id") int id) {
    	Type types = typeService.getId(id);
        return new ResponseEntity<Type>(types, HttpStatus.OK);
    }
    //creat
    @RequestMapping(value = "/type/",method = RequestMethod.POST)
    public ResponseEntity<?> creatType(Type type, UriComponentsBuilder ucBuilder) throws ParseException {
    	Type types=typeService.add(type); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/kurita/type/{id}").buildAndExpand(types.getIdtype()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    //update
    @RequestMapping(value = "/type/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateType(Type type) throws ParseException{
    	Type currentType=typeService.update(type);
        return new ResponseEntity<Type>(currentType, HttpStatus.OK);
    }
    //delete 1 entity
    @RequestMapping(value = "/type/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteType(@PathVariable("id") int id) {
        if(typeService.delete(id)) {
        	
        	return new ResponseEntity<Type>(HttpStatus.NO_CONTENT);
        }
        else
        	return new ResponseEntity("no delete  with id {} khong co.",HttpStatus.NOT_FOUND);
    }
}
