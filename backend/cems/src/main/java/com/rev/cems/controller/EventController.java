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

import com.rev.cems.entity.Event;
import com.rev.cems.exception.EventNotFoundException;
import com.rev.cems.exception.FestNotFoundException;
import com.rev.cems.service.EventServiceImpl;



@RestController
public class EventController {

	@Autowired
	private EventServiceImpl eventServiceImpl;
	
	
	
    @GetMapping("/fest/{id}/event")
    public  ResponseEntity<List<Event>> getAllEvent(@PathVariable("id") Long festId) {
    
    	List<Event> eventList= eventServiceImpl.getAllEvent(festId);
		return new ResponseEntity<List<Event>>(eventList, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/fest/{id}/event/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long festId,@PathVariable("eventId") Long eventId) {
  
    	return	new ResponseEntity<Event>(eventServiceImpl.getEventById(festId,eventId), new HttpHeaders(), HttpStatus.OK);
    	
    }
    
    @PostMapping("/fest/{id}/event")
    public ResponseEntity<String> createEvent(@PathVariable("id") Long festId, @RequestBody Event event) {
     if( eventServiceImpl.createEvent(festId,event)==null)
    	 return new ResponseEntity<String>("Error occured.. Couldn't create Event ",new HttpHeaders(),HttpStatus.OK);
     else
    	  return new ResponseEntity<String>("Event Created Successfully!",new HttpHeaders(),HttpStatus.OK);
    }
    
    @PutMapping("/fest/{id}/event/{eventId}")
    public ResponseEntity<String> updateEvent(@PathVariable("id") Long festId,@PathVariable("eventId") Long eventId,@RequestBody Event eventUpdated){
     
        if(eventServiceImpl.updateEvent(festId,eventId,eventUpdated)==null)
       	 return new ResponseEntity<String>("Error occured.. Couldn't update Fest ",new HttpHeaders(),HttpStatus.OK);
        else
       	  return new ResponseEntity<String>("Fest updated Successfully!",new HttpHeaders(),HttpStatus.OK);
               
    }
    
    @DeleteMapping("/fest/{id}/event/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long festId,@PathVariable("eventId") Long eventId) {
        return new ResponseEntity<String>(eventServiceImpl.deleteEvent(festId,eventId),new HttpHeaders(),HttpStatus.OK);
    }
 
 
 @ExceptionHandler(EventNotFoundException.class)
	public ResponseEntity<String> eventNotFound(EventNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
 
 @ExceptionHandler(FestNotFoundException.class)
	public ResponseEntity<String> festNotFound(FestNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
 


}
