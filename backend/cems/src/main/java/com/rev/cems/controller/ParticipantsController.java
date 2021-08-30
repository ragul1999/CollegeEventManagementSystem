package com.rev.cems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.cems.entity.College;
import com.rev.cems.entity.Participants;
import com.rev.cems.exception.IdNotFoundException;
import com.rev.cems.service.CollegeServiceImpl;
import com.rev.cems.service.ParticipantsServiceImpl;
import com.rev.cems.util.MailSend;
import com.rev.cems.util.RandomString;

@RestController
public class ParticipantsController {

	@Autowired
	ParticipantsServiceImpl participantsServiceImpl;
	
	@Autowired
	CollegeServiceImpl collegeServiceImpl;
	
	@PostMapping("/college/{id}/participants/create")
	public ResponseEntity<String> createParticipant(@PathVariable Long id, @RequestBody Participants participant)
	{
		College list = null;
		list = collegeServiceImpl.getCollegeById(id);
		if(list!=null) {
			participant.setCollege(list);
			String password=RandomString.randomPassword();
			participant.setPassword(password);
			Participants p=participantsServiceImpl.createParticipant(participant);
			if(p==null)
			{
				throw new IdNotFoundException("Enter Valid Id");
					
			}
			List<String> x = new ArrayList<String>();
			x.add(participant.getEmailId());
			String message="Your Temporary Password for Login is:\n"+password+"\nThank you.";
			MailSend.sendMail(x,"Temporary Password For Login", message);
		}
		
		return new ResponseEntity<String>("Participants Created Successfully!",new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/participants/{id}")
	public ResponseEntity<Participants> getParticipant(@PathVariable("id") Long id)
	{
		
		Participants p=participantsServiceImpl.getParticipantById(id);
		if(p==null)
		{
			
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		}
		return  new ResponseEntity<Participants>(p,new HttpHeaders(),HttpStatus.OK);
	}	
	
	@GetMapping("/participants")
	public ResponseEntity<List<Participants>> getAllParticipants()
	{
		List<Participants> p=participantsServiceImpl.getAllParticipant();
		
		return new ResponseEntity<List<Participants>>(p,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@PutMapping("/participants/update")
	public ResponseEntity<String> updateCollege(@RequestBody Participants participant)
	{
		Participants p=participantsServiceImpl.updateParticipant(participant);
		if(p==null)
		{
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("Participant Updated Successfully!",new HttpHeaders(),HttpStatus.OK);

		
	}
	
	@DeleteMapping("/participants/delete/{id}")
	public ResponseEntity<String> deleteCollege(@PathVariable("id") Long id)
	{
		Participants p=participantsServiceImpl.deleteParticipant(id);
		if(p==null)
		{
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("Participant Deleted Successfully!",new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	

}
