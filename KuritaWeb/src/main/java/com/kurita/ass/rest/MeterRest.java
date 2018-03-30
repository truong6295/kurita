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

import com.kurita.ass.model.Meter;
import com.kurita.ass.model.User;
import com.kurita.ass.service.MeterService;

@RestController
@RequestMapping("/kurita")
public class MeterRest {
	@Autowired
    private MeterService meterService; 
    //view all
    @RequestMapping(value = "/meter/", method = RequestMethod.GET)
    public ResponseEntity<List<Meter>> listAllMeter() {
        List<Meter> meters = meterService.getAll();
        if (meters.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Meter>>(meters, HttpStatus.OK);
    }
    //view 1 entity
    @RequestMapping(value = "/meter/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMeter(@PathVariable("id") int id) {
    	Meter meters = meterService.getId(id);
        return new ResponseEntity<Meter>(meters, HttpStatus.OK);
    }
    //creat
    @RequestMapping(value = "/meter/",method = RequestMethod.POST)
    public ResponseEntity<?> creatMeter(Meter meter, UriComponentsBuilder ucBuilder) throws ParseException {
    	Meter meters=meterService.add(meter); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/kurita/meter/{id}").buildAndExpand(meters.getIdmeter()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    //update
    @RequestMapping(value = "/meter/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMeter(Meter meter) throws ParseException{
    	Meter currentMeter=meterService.update(meter);
        return new ResponseEntity<Meter>(currentMeter, HttpStatus.OK);
    }
    //delete 1 entity
    @RequestMapping(value = "/meter/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMeter(@PathVariable("id") int id) {
        if(meterService.delete(id)) {
        	
        	return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        else
        	return new ResponseEntity("no delete  with id {} khong co.",HttpStatus.NOT_FOUND);
    }
}
