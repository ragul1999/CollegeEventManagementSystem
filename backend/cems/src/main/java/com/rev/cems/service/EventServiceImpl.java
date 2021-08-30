package com.rev.cems.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.cems.dao.EventDaoImpl;
import com.rev.cems.dao.FestDaoImpl;
import com.rev.cems.entity.Event;
import com.rev.cems.exception.EventNotFoundException;
import com.rev.cems.exception.FestNotFoundException;
import com.rev.cems.util.MailSend;


@Service
@Transactional
public class EventServiceImpl implements EventService{

	@Autowired
	private EventDaoImpl eventDaoImpl;
	
	@Autowired
	private FestDaoImpl festDaoImpl;
	
	@Autowired
	private EventParticipantsServiceImpl eventParticipantsServiceImpl;
	
	@Override
	public List<Event> getAllEvent(Long festId) {
		if(!festDaoImpl.existsById(festId)) 
    		throw new FestNotFoundException("Fest not found!");
		
			 List<Event> optFest = eventDaoImpl.findAllEvents(festId);
			  if(optFest!=null) {
				 return optFest;
		    	}else {
		    		throw new FestNotFoundException("Event not found!");
		    	}
		 }
		
	

	@Override
	public Event getEventById(Long festId,Long eventId) {
		if(!festDaoImpl.existsById(festId)) 
    		throw new FestNotFoundException("Fest not found!");
		
		 Optional<Event> optFest = eventDaoImpl.findEventById(festId,eventId);
		  if(optFest.isPresent()) {
	    		return optFest.get();
	    	}else {
	    		throw new EventNotFoundException("Event not found with id " + eventId);
	    	}
	}

	@Override
	public Object createEvent(Long festId,Event event) {
		return festDaoImpl.findById(festId)
                .map(fest -> {
                	event.setFest(fest);
                    return eventDaoImpl.save(event);
                }).orElseThrow(() -> new FestNotFoundException("Fest not found!"));
		
		 
	}

	@Override
	public Object updateEvent(Long festId,Long eventId, Event eventUpdated) {
		
		if(!festDaoImpl.existsById(festId)) 
    		throw new FestNotFoundException("Fest not found!");
		
		return eventDaoImpl.findById(eventId)
			.map(event -> {
				event.setName(eventUpdated.getName());
				event.setDescription(eventUpdated.getDescription());
				event.setType(eventUpdated.getType());
				event.setMaxSeats(eventUpdated.getMaxSeats());
				event.setAvailSeats(eventUpdated.getAvailSeats());
				event.setEventDate(eventUpdated.getEventDate());
				event.setEventTime(eventUpdated.getEventTime());
				event.setContactMail(eventUpdated.getContactMail());
				
			return eventDaoImpl.save(event);
			}).orElseThrow(() -> new EventNotFoundException("Event not found with id " + eventId));  
	
			
	}

	@Override
	public String deleteEvent(Long festId,Long eventId) {
		if(!festDaoImpl.existsById(festId)) {
    		throw new FestNotFoundException("Fest not found!");
    	}
		 return eventDaoImpl.findById(eventId)
	                .map(event -> {
	                	eventDaoImpl.delete(event);
	                    return "Event Deleted Successfully!";
	                }).orElseThrow(() -> new EventNotFoundException("Event not found with id " + eventId));
	    }



	@Override
	public Event getEventById(Long id) {
		
		return eventDaoImpl.findById(id).get();
	
	}
	
	public Date addDate(Date date, int days) {
		
		
		String str=new SimpleDateFormat("dd-MM-yyyy").format(date);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(str,format);
		localDate=localDate.plusDays(days);
		Date addedDate = java.sql.Date.valueOf(localDate);
		return addedDate;
	}
	
	@Override
	public int updateDate(Long festId, int days) {
		List<Event> event = getAllEvent(festId);
		if(event.isEmpty()==false) {
		for(Event e:event)
		{
			e.setEventDate(addDate(e.getEventDate(),days));
			updateEvent(e.getFest().getId(),e.getId(),e);
			List<String> email=eventParticipantsServiceImpl.getPartipantsByEventId(e.getId());
			String message = "Event Date has been updated to: "+e.getEventDate().toString();
			MailSend.sendMail(email, "Updated Event Dates", message);
		}
		return 1;
		}
		return 0;
	}

}






