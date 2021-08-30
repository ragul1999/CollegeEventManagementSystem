package com.rev.cems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rev.cems.entity.EventParticipants;

@Repository
public interface EventParticipantsDaoImpl extends JpaRepository<EventParticipants,Long>{

	
	@Query("SELECT e FROM EventParticipants e WHERE e.event.id=:eventId")
	public List<EventParticipants> getPartipantsByEventId(@Param("eventId") Long eventId);

}
