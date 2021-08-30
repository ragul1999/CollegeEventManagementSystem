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

import com.rev.cems.entity.College;
import com.rev.cems.entity.Hostel;
import com.rev.cems.exception.IdNotFoundException;
import com.rev.cems.service.CollegeServiceImpl;
import com.rev.cems.service.HostelServiceImpl;

@RestController
public class HostelController {

	@Autowired
	HostelServiceImpl hostelServiceImpl;
	
	@Autowired
	CollegeServiceImpl collegeServiceImpl;
	
	@PostMapping("/college/{id}/hostel/create")
	public ResponseEntity<String> createHostel(@PathVariable("id") Long id, @RequestBody Hostel hostel)
	{
		College list = null;
		list = collegeServiceImpl.getCollegeById(id);
		if(list!=null) {
			hostel.setCollege(list);
			Hostel h = hostelServiceImpl.createHostel(hostel);
			if(h==null)
			{
				throw new IdNotFoundException("Enter Valid Id");
					
			}
		}
		
		return new ResponseEntity<String>("Hostel Created Successfully!",new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/hostel/{id}")
	public ResponseEntity<Hostel> getHostel(@PathVariable("id") Long id)
	{
		
		Hostel h = hostelServiceImpl.getHostelById(id);
		if(h==null)
		{
			
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		}
		return  new ResponseEntity<Hostel>(h ,new HttpHeaders(),HttpStatus.OK);
	}	
	
	@GetMapping("/hostel")
	public ResponseEntity<List<Hostel>> getAllHostel()
	{
		List<Hostel> h = hostelServiceImpl.getAllHostel();
		
		return new ResponseEntity<List<Hostel>>(h ,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@PutMapping("/hostel/update")
	public ResponseEntity<String> updateHostel(@RequestBody Hostel hostel)
	{
		Hostel h = hostelServiceImpl.updateHostel(hostel);
		if(h==null)
		{
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("Hostel Updated Successfully!",new HttpHeaders(),HttpStatus.OK);

		
	}
	
	@DeleteMapping("/hostel/delete/{id}")
	public ResponseEntity<String> deleteHostel(@PathVariable("id") Long id)
	{
		Hostel h = hostelServiceImpl.deleteHostel(id);
		if(h==null)
		{
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("Hostel Deleted Successfully!",new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
