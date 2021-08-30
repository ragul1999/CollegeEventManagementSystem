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
import com.rev.cems.exception.IdNotFoundException;
import com.rev.cems.service.CollegeServiceImpl;

@RestController
public class CollegeController {

	@Autowired
	CollegeServiceImpl collegeServiceImpl;
	
	@PostMapping("/createCollege")
	public ResponseEntity<String> createCollege(@RequestBody College college)
	{
	
		College c=collegeServiceImpl.createCollege(college);
		if(c==null)
		{
			throw new IdNotFoundException("Enter Valid Id");
				
		}
		return new ResponseEntity<String>("College Created Successfully!",new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/getCollege/{id}")
	public ResponseEntity<College> getCollege(@PathVariable("id") Long id)
	{
		
		College c=collegeServiceImpl.getCollegeById(id);
		if(c==null)
		{
			
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		}
		return  new ResponseEntity<College>(c,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllCollege")
	public ResponseEntity<List<College>> getAllCollege()
	{
		List<College> c=collegeServiceImpl.getAllCollege();
		
		return new ResponseEntity<List<College>>(c,new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@PutMapping("/updateCollege")
	public ResponseEntity<String> updateCollege(@RequestBody College c)
	{
		College col=collegeServiceImpl.updateCollege(c);
		if(col==null)
		{
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("College Updated Successfully!",new HttpHeaders(),HttpStatus.OK);

		
	}
	
	@DeleteMapping("/deleteCollege/{id}")
	public ResponseEntity<String> deleteCollege(@PathVariable("id") Long id)
	{
		College c=collegeServiceImpl.deleteCollege(id);
		if(c==null)
		{
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
				
		}
		return new ResponseEntity<String>("College Deleted Successfully!",new HttpHeaders(),HttpStatus.OK);
		
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
}
