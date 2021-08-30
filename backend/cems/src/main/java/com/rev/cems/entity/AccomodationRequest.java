package com.rev.cems.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="AccomodationRequest")
public class AccomodationRequest {



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@OneToOne
	@JoinColumn(name = "participants_id", nullable=false, unique = true)
	private Participants participants;
	
	private String status;
	
	public AccomodationRequest()
	{
		
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AccomodationRequest [id=" + id + ", participants=" + participants + ", status=" + status + "]";
	}
	
	
	
	
	
}
