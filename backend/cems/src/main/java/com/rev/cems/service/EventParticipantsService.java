package com.rev.cems.service;

import java.util.List;


import com.rev.cems.entity.EventParticipants;
import com.rev.cems.entity.Participants;

public interface EventParticipantsService {

	List<EventParticipants> getAllEventParticipants();

	EventParticipants getEventParticipantsById(Long id);

	EventParticipants createEventParticipants(EventParticipants eventParticipants);

	EventParticipants updateEventParticipants(EventParticipants eventParticipants);

	EventParticipants deleteEventParticipants(Long id);
	
    List<String> getPartipantsByEventId( Long eventId);
}
