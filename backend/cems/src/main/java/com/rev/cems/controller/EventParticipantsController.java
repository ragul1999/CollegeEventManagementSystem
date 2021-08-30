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

import com.rev.cems.entity.EventParticipants;
import com.rev.cems.entity.Event;

import com.rev.cems.entity.Participants;
import com.rev.cems.exception.IdNotFoundException;
import com.rev.cems.service.EventParticipantsServiceImpl;
import com.rev.cems.service.EventServiceImpl;
import com.rev.cems.service.ParticipantsServiceImpl;

@RestController
public class EventParticipantsController {

	@Autowired
	ParticipantsServiceImpl participantSeriveImpl;
	
	@Autowired 
	EventServiceImpl eventServiceImpl;
	
	@Autowired
	EventParticipantsServiceImpl eventParticipantsServiceImpl;
	
	
	
	@PostMapping("/participant/{pId}/event/{eId}/event-participant/create")
	public ResponseEntity<String> createEventParticipants(@PathVariable("pId") Long pId, @PathVariable("eId") Long eId, @RequestBody EventParticipants eventParticipants)
	{
		Participants participant = null;
		participant = participantSeriveImpl.getParticipantById(pId);
		Event event = null;
		event = eventServiceImpl.getEventById(eId);
		if(participant!=null && event!=null) {
			eventParticipants.setParticipant(participant);
			if(event.getAvailSeats()>0) {
				event.setAvailSeats(event.getAvailSeats()-1);
				event=(Event)eventServiceImpl.updateEvent(event.getFest().getId(), eId, event);
				eventParticipants.setEvent(event);
				EventParticipants e = eventParticipantsServiceImpl.createEventParticipants(eventParticipants);
					if(e==null)
					{
						throw new IdNotFoundException("Enter Valid Id");
							
					}
			}
			else
			{
				return new ResponseEntity<String>("No slot in this hostel..:(", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<String>("Event Participants Created Successfully!",new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/event-participant/{id}")
	public ResponseEntity<EventParticipants> getEventParticipants(@PathVariable("id") Long id)
	{
		
		EventParticipants e = eventParticipantsServiceImpl.getEventParticipantsById(id);
	
		if(e==null)
		{
			
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		}
		return  new ResponseEntity<EventParticipants>(e,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/event-participant")
	public ResponseEntity<List<EventParticipants>> getAllEventParticipants()
	{
		List<EventParticipants> ar = eventParticipantsServiceImpl.getAllEventParticipants();
		
		return new ResponseEntity<List<EventParticipants>>(ar,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@PutMapping("/event-participant/update")
	public ResponseEntity<String> updateEventParticipants(@RequestBody EventParticipants EventParticipants)
	{
		EventParticipants ar = eventParticipantsServiceImpl.updateEventParticipants(EventParticipants);
		if(ar==null)
		{
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("Event Participants Updated Successfully!",new HttpHeaders(),HttpStatus.OK);

		
	}
	
	@DeleteMapping("/event-participant/delete/{id}")
	public ResponseEntity<String> deleteEventParticipants(@PathVariable("id") Long id)
	{
		EventParticipants ar = eventParticipantsServiceImpl.deleteEventParticipants(id);
		if(ar==null)
		{
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("Event Participants Deleted Successfully!",new HttpHeaders(),HttpStatus.OK);
		
	}
	
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
