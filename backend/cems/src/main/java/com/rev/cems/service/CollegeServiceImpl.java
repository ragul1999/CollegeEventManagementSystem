package com.rev.cems.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.cems.dao.CollegeDaoImpl;
import com.rev.cems.entity.College;


@Service
@Transactional
public class CollegeServiceImpl implements CollegeService{
	
	@Autowired
	CollegeDaoImpl collegeDaoImpl;
	
	
	@Override
	public College createCollege(College college) {
		return collegeDaoImpl.save(college);
		
	}
	
	@Override
	public College deleteCollege(Long id) {
	
		College c = collegeDaoImpl.findById(id).get();
		if(c!=null)
			collegeDaoImpl.deleteById(id);
			return c;
		
	
	}
	
	@Override
	public List<College> getAllCollege() {
	
		return collegeDaoImpl.findAll();
	}
	
	@Override
	public College getCollegeById(Long id) {
	
		return collegeDaoImpl.findById(id).get();
	}
	
	@Override
	public College updateCollege(College college) {
		boolean b=collegeDaoImpl.existsById(college.getId());
		College c=new College();
		if(b)
		{
			collegeDaoImpl.save(college);
			c=collegeDaoImpl.findById(college.getId()).get();
		}
		return c;
	
	
	}
	

}
