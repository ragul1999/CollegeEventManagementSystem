package com.rev.cems.service;

import java.util.List;

import com.rev.cems.entity.Event;


public interface EventService {

	List<Event> getAllEvent(Long festId);

	Event getEventById(Long festId, Long eventId);
	
	Event getEventById(Long id);

	Object createEvent(Long festId,Event event);

	Object updateEvent(Long festId,Long eventId, Event eventUpdated);
	
	int updateDate(Long festId,int days);

	String deleteEvent(Long festId,Long eventId);

	

}
