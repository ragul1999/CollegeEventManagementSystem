package com.rev.cems.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EventParticipants")
public class EventParticipants {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="participant_id", nullable=false)
	private Participants participant;
	
	@ManyToOne
	@JoinColumn(name="event_id", nullable=false)
	private Event event;
	
	public EventParticipants() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Participants getParticipant() {
		return participant;
	}

	public void setParticipant(Participants participant) {
		this.participant = participant;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "EventParticipants [id=" + id + ", participant=" + participant + ", event=" + event + "]";
	}
	
}
