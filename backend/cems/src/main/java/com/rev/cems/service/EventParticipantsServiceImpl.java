package com.rev.cems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.cems.dao.EventParticipantsDaoImpl;
import com.rev.cems.entity.EventParticipants;
import com.rev.cems.entity.Participants;

@Service
@Transactional
public class EventParticipantsServiceImpl implements EventParticipantsService{

	@Autowired
	EventParticipantsDaoImpl eventParticipantsDaoImpl;
	
	@Override
	public List<EventParticipants> getAllEventParticipants() {
		return eventParticipantsDaoImpl.findAll();
	}

	@Override
	public EventParticipants getEventParticipantsById(Long id) {
		return eventParticipantsDaoImpl.findById(id).get();
	}

	@Override
	public EventParticipants createEventParticipants(EventParticipants eventParticipants) {
		return eventParticipantsDaoImpl.save(eventParticipants);
	}

	@Override
	public EventParticipants updateEventParticipants(EventParticipants eventParticipants) {
		
		boolean b=eventParticipantsDaoImpl.existsById(eventParticipants.getId());
		EventParticipants ar=new EventParticipants();
		if(b)
		{
			eventParticipantsDaoImpl.save(eventParticipants);
			ar=eventParticipantsDaoImpl.findById(eventParticipants.getId()).get();
		}
		return ar;	
	}

	@Override
	public EventParticipants deleteEventParticipants(Long id) {
		
		EventParticipants ar = eventParticipantsDaoImpl.findById(id).get();
		if(ar!=null)
			eventParticipantsDaoImpl.deleteById(id);
		return ar;
	
	}
	
	@Override
	public List<String> getPartipantsByEventId(Long eventId) {
		List<EventParticipants> l=eventParticipantsDaoImpl.getPartipantsByEventId(eventId);
		List<String> emailList= new ArrayList<String>();
		for(EventParticipants x:l)
		{
			emailList.add(x.getParticipant().getEmailId());

		}
		
		return emailList;
		
	}

}
