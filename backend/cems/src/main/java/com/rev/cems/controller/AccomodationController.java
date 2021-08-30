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

import com.rev.cems.entity.Accomodation;
import com.rev.cems.entity.Hostel;
import com.rev.cems.entity.Participants;
import com.rev.cems.exception.IdNotFoundException;
import com.rev.cems.service.AccomodationServiceImpl;
import com.rev.cems.service.HostelServiceImpl;
import com.rev.cems.service.ParticipantsServiceImpl;

@RestController
public class AccomodationController {

	@Autowired
	ParticipantsServiceImpl participantSeriveImpl;
	
	@Autowired 
	HostelServiceImpl hostelServiceImpl;
	
	@Autowired
	AccomodationServiceImpl accomodationServiceImpl;
	
	
	
	@PostMapping("/participant/{pId}/hostel/{hId}/accomodation/create")
	public ResponseEntity<String> createAccomodation(@PathVariable("pId") Long pId, @PathVariable("hId") Long hId, @RequestBody Accomodation accomodation)
	{
		Participants participant = null;
		participant = participantSeriveImpl.getParticipantById(pId);
		Hostel hostel = null;
		hostel = hostelServiceImpl.getHostelById(hId);
		if(participant!=null && hostel!=null) {
			accomodation.setParticipants(participant);
			if(hostel.getAvailableSlots()>0) {
				hostel.setAvailableSlots(hostel.getAvailableSlots()-1);
				hostel = hostelServiceImpl.updateHostel(hostel);
				accomodation.setHostel(hostel);
				Accomodation a = accomodationServiceImpl.createAccomodation(accomodation);
				if(a==null)
				{
					throw new IdNotFoundException("Enter Valid Id");
						
				}
			}
			else {
				return new ResponseEntity<String>("No slot in this hostel..:(", new HttpHeaders(), HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<String>("Accomodation Created Successfully!",new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/accomodation/{id}")
	public ResponseEntity<Accomodation> getAccomodation(@PathVariable("id") Long id)
	{
		
		Accomodation a = accomodationServiceImpl.getAccomodationById(id);
	
		if(a==null)
		{
			
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		}
		return  new ResponseEntity<Accomodation>(a,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/accomodation")
	public ResponseEntity<List<Accomodation>> getAllAccomodation()
	{
		List<Accomodation> ar = accomodationServiceImpl.getAllAccomodation();
		
		return new ResponseEntity<List<Accomodation>>(ar,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@PutMapping("/accomodation/update")
	public ResponseEntity<String> updateAccomodation(@RequestBody Accomodation accomodation)
	{
		Accomodation ar = accomodationServiceImpl.updateAccomodation(accomodation);
		if(ar==null)
		{
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("Accomodation Updated Successfully!",new HttpHeaders(),HttpStatus.OK);

		
	}
	
	@DeleteMapping("/accomodation/delete/{id}")
	public ResponseEntity<String> deleteAccomodation(@PathVariable("id") Long id)
	{
		Accomodation ar = accomodationServiceImpl.deleteAccomodation(id);
		if(ar==null)
		{
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
				
		}
		Hostel h = ar.getHostel();
		h.setAvailableSlots(h.getAvailableSlots()+1);
		h = hostelServiceImpl.updateHostel(h);
		if(h==null)
		{
			throw new IdNotFoundException("Update Operation for available slots is Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("Accomodation Deleted Successfully!",new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
