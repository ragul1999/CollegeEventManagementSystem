package com.rev.cems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.cems.entity.Fest;
import com.rev.cems.exception.FestNotFoundException;
import com.rev.cems.exception.IdNotFoundException;
import com.rev.cems.service.FestServiceImpl;



@RestController
public class FestController {
	

	@Autowired
	private FestServiceImpl festServiceImpl;
	
	
    @GetMapping("/fest")
    public  ResponseEntity<List<Fest>> getAllFest() {
    	List<Fest> festList= festServiceImpl.getAllFest();
		return new ResponseEntity<List<Fest>>(festList, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/fest/{id}")
    public ResponseEntity<Fest> getFestById(@PathVariable Long id) {
  
    	return	new ResponseEntity<Fest>(festServiceImpl.getFestById(id), new HttpHeaders(), HttpStatus.OK);
    	
    }
    
    @PostMapping("/fest")
    public ResponseEntity<String> createFest( @RequestBody Fest fest) {
     if( festServiceImpl.createFest(fest)==null)
    	 return new ResponseEntity<String>("Error occured.. Couldn't create Fest ",new HttpHeaders(),HttpStatus.OK);
     else
    	  return new ResponseEntity<String>("Fest Created Successfully!",new HttpHeaders(),HttpStatus.OK);
    }
    
    @PutMapping("/fest/{id}")
    public ResponseEntity<String> updateFest(@PathVariable Long id,@RequestBody Fest festUpdated) {
     
        if(festServiceImpl.updateFest(id,festUpdated)==null)
       	 return new ResponseEntity<String>("Error occured.. Couldn't update Fest ",new HttpHeaders(),HttpStatus.OK);
        else
       	  return new ResponseEntity<String>("Fest updated Successfully!",new HttpHeaders(),HttpStatus.OK);
               
    }
    
    @DeleteMapping("/fest/{id}")
    public ResponseEntity<String> deleteFest(@PathVariable Long id) {
        return new ResponseEntity<String>(festServiceImpl.deleteFest(id),new HttpHeaders(),HttpStatus.OK);
    }
 
    @PutMapping("/fest/{id}/update-date")
 	public ResponseEntity<String> updateDate(@PathVariable("id") Long id, @RequestBody String date) {
    	
    	Fest f=festServiceImpl.updateDate(id, date);
		if(f==null)
		{
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("Fest and Event Dates Updated Successfully!",new HttpHeaders(),HttpStatus.OK);
    }
 
 @ExceptionHandler(FestNotFoundException.class)
	public ResponseEntity<String> userNotFound(FestNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
 
 

}
