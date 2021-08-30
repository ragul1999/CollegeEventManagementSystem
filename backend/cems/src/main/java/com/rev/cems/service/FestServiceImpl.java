package com.rev.cems.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.rev.cems.dao.FestDaoImpl;
import com.rev.cems.entity.Fest;
import com.rev.cems.exception.FestNotFoundException;


@Service
@Transactional
public class FestServiceImpl implements FestService{
	@Autowired
	private FestDaoImpl festDaoImpl;
	
	@Autowired
	private EventServiceImpl eventServiceImpl;

	public int differenceDate(Date current, Date previous) {
		int diff = (int) ((current.getTime() - previous.getTime()) / (1000*60*60*24));
		return diff;
	}
	
	public Date addDate(Date date, int days) {
		
		
		String str=new SimpleDateFormat("dd-MM-yyyy").format(date);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(str,format);
		localDate=localDate.plusDays(days);
		Date addedDate = java.sql.Date.valueOf(localDate);
		return addedDate;
	}
	
	 public List<Fest> getAllFest(){
		 return festDaoImpl.findAll();
	 }
	 
	  public Fest getFestById(@PathVariable Long id) {
		  Optional<Fest> optFest = festDaoImpl.findById(id);
		  if(optFest.isPresent()) {
	    		return optFest.get();
	    	}else {
	    		throw new FestNotFoundException("Fest not found with id " + id);
	    	}
	  }
	  
	  public Fest createFest( @RequestBody Fest fest) {
		  return festDaoImpl.save(fest);
	  }
	  
	  public Fest updateFest(@PathVariable Long id,
			              @RequestBody Fest festUpdated){
		
		return festDaoImpl.findById(id)
			.map(fest -> {
				fest.setName(festUpdated.getName());
				fest.setStartDate(festUpdated.getStartDate());
				fest.setEndDate(festUpdated.getEndDate());
				fest.setCollegeId(festUpdated.getCollegeId());
			return festDaoImpl.save(fest);
			}).orElseThrow(() -> new FestNotFoundException("Fest not found with id " + id));  
			
	  }
	  
	  public String deleteFest(@PathVariable Long id) {
	        return festDaoImpl.findById(id)
	                .map(fest -> {
	                	festDaoImpl.delete(fest);
	                    return "Fest Deleted Successfully!";
	                }).orElseThrow(() -> new FestNotFoundException("Fest not found with id " + id));
	    }
	  @Override
		public Fest updateDate(Long id, String date) {
			Fest f = festDaoImpl.getById(id);
			if(f!=null ) {
				Date previousDate = f.getStartDate(); 
			    try {
					Date currentDate=new SimpleDateFormat("dd-MM-yyyy").parse(date);
					int difference = differenceDate(currentDate, previousDate);
					f.setStartDate(currentDate);
					f.setEndDate(addDate(f.getEndDate(), difference));
					festDaoImpl.save(f);
					System.out.println(eventServiceImpl.updateDate(id, difference));
					f = festDaoImpl.getById(id);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
			}
			return f;
		}
}
