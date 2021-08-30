package com.rev.cems.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rev.cems.entity.Event;


@Repository
public interface EventDaoImpl extends JpaRepository<Event,Long> {
	
	@Query("select e from Event e where e.fest.id=?1")
	List<Event> findAllEvents(@Param("festId")Long festId); 

	@Query("from Event e where e.fest.id=:festId and id=:eventId")
	Optional<Event> findEventById(@Param("festId") Long festId,@Param("eventId") Long eventId);
	

}
