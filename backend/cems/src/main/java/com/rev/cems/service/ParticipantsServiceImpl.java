package com.rev.cems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.cems.dao.ParticipantsDaoImpl;
import com.rev.cems.entity.Participants;

@Service
@Transactional
public class ParticipantsServiceImpl implements ParticipantsService{

	@Autowired
	ParticipantsDaoImpl participantsDaoImpl;
	
	@Override
	public Participants createParticipant(Participants participant) {
		return participantsDaoImpl.save(participant);
	}

	@Override
	public Participants getParticipantById(Long id) {
		return participantsDaoImpl.findById(id).get();
	}

	@Override
	public List<Participants> getAllParticipant() {
		return participantsDaoImpl.findAll();
	}

	@Override
	public Participants deleteParticipant(Long id) {
		
		Participants p = participantsDaoImpl.findById(id).get();
		if(p!=null)
			participantsDaoImpl.deleteById(id);
		return p;
		
	}

	@Override
	public Participants updateParticipant(Participants participant) {
	
		boolean b=participantsDaoImpl.existsById(participant.getId());
		Participants p=new Participants();
		if(b)
		{
			participantsDaoImpl.save(participant);
			p=participantsDaoImpl.findById(participant.getId()).get();
		}
		return p;
	}

}
