package com.rev.cems.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Accomodation")
public class Accomodation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "participants_id", nullable=false, unique = true)
	private Participants participants;
	
	@ManyToOne
	@JoinColumn(name="hostel_id", nullable=false)
	private Hostel hostel;

	public Accomodation() {
		
	}
	
	public Long getId() {
		return id;
	}

	public Participants getParticipants() {
		return participants;
	}

	public void setParticipants(Participants participants) {
		this.participants = participants;
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

	@Override
	public String toString() {
		return "Accomodation [id=" + id + ", participants=" + participants + ", hostel=" + hostel + "]";
	}
	
}
