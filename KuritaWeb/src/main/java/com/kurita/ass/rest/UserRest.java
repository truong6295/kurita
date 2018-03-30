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

import com.kurita.ass.model.User;
import com.kurita.ass.service.UserService;


@RestController
@RequestMapping("/kurita")
public class UserRest {
	@Autowired
    private UserService userService;
    //view all
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUser() {
        List<User> users = userService.getAll();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    //view 1 entity
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") int id) {
    	User users = userService.getId(id);
        return new ResponseEntity<User>(users, HttpStatus.OK);
    }
    //creat
    @RequestMapping(value = "/user/",method = RequestMethod.POST)
    public ResponseEntity<?> creatUser(User user, UriComponentsBuilder ucBuilder) throws ParseException {
        User users=userService.add(user); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/kurita/user/{id}").buildAndExpand(users.getIduser()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    //update
    @RequestMapping(value = "/user/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(User user) throws ParseException{
        User currentUser=userService.update(user);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
    //delete 1 entity
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        if(userService.delete(id)) {
        	
        	return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        else
        	return new ResponseEntity("no delete personal with id {} khong co.",HttpStatus.NOT_FOUND);
    }
}
