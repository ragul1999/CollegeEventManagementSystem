package com.rev.cems.controller;

import java.util.ArrayList;
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

import com.rev.cems.entity.AccomodationRequest;
import com.rev.cems.entity.Participants;
import com.rev.cems.exception.IdNotFoundException;
import com.rev.cems.service.AccomodationRequestServiceImpl;
import com.rev.cems.service.ParticipantsServiceImpl;
import com.rev.cems.util.MailSend;

@RestController
public class AccomodationRequestController {

	@Autowired
	ParticipantsServiceImpl participantsServiceImpl;
	
	@Autowired
	AccomodationRequestServiceImpl accomodationRequestServiceImpl;
	
	
	
	@PostMapping("/participants/{id}/accomodation-request/create")
	public ResponseEntity<String> createRequest(@PathVariable Long id, @RequestBody AccomodationRequest accomodationRequest)
	{
		Participants list = null;
		list = participantsServiceImpl.getParticipantById(id);
		if(list!=null) {
			accomodationRequest.setParticipants(list);
			AccomodationRequest ar=accomodationRequestServiceImpl.createAccomodationRequest(accomodationRequest);
			if(ar==null)
			{
				throw new IdNotFoundException("Enter Valid Id");
					
			}
		}
		
		return new ResponseEntity<String>("Accomodation Request Created Successfully!",new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/accomodation-request/{id}")
	public ResponseEntity<AccomodationRequest> getRequest(@PathVariable("id") Long id)
	{
		
		AccomodationRequest ar=accomodationRequestServiceImpl.getAccomodationRequestById(id);
		
		if(ar==null)
		{
			
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		}
		return  new ResponseEntity<AccomodationRequest>(ar,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/accomodation-request")
	public ResponseEntity<List<AccomodationRequest>> getAllRequest()
	{
		List<AccomodationRequest> ar=accomodationRequestServiceImpl.getAllAccomodationRequest();
		
		return new ResponseEntity<List<AccomodationRequest>>(ar,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	
	@PutMapping("/accomodation-request/update/{id}")
	public ResponseEntity<String> updateRequest(@RequestBody String status,@PathVariable("id") Long id)
	{
		
		AccomodationRequest ar=accomodationRequestServiceImpl.updateAccomodationRequest(status,id);
		if(ar==null)
		{
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
				
		}
		List<String> x = new ArrayList<String>();
		x.add(ar.getParticipants().getEmailId());
		String message="Your Request for Accomodation has been:\n"+ar.getStatus()+"\nThank you.";
		MailSend.sendMail(x,"Accomodation Status", message);
		return new ResponseEntity<String>("Accomodation Request Updated Successfully!",new HttpHeaders(),HttpStatus.OK);

		
	}
	
	@DeleteMapping("/accomodation-request/delete/{id}")
	public ResponseEntity<String> deleteRequest(@PathVariable("id") Long id)
	{
		AccomodationRequest ar=accomodationRequestServiceImpl.deleteAccomodationRequest(id);
		if(ar==null)
		{
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("Accomodation Request Deleted Successfully!",new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
