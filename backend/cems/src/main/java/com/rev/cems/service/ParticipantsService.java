package com.rev.cems.service;

import java.util.List;

import com.rev.cems.entity.Participants;

public interface ParticipantsService {

	Participants createParticipant(Participants participant) ;
	
	Participants getParticipantById(Long id);
	
	List<Participants> getAllParticipant();

	Participants deleteParticipant(Long id);

	Participants updateParticipant(Participants participant);
}
