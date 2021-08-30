package com.rev.cems.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Participants")
public class Participants {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String emailId;
	private Double contactNumber;
	private String password;
	
	@ManyToOne
	@JoinColumn(name="college_id", nullable=false)
	private College college;
	
	@OneToMany(mappedBy="participant",cascade=CascadeType.ALL)
	private List<EventParticipants> eventParticipants;
	
	@OneToOne(mappedBy="participants",cascade=CascadeType.ALL)
	private Accomodation accomodation;
	
	@OneToOne(mappedBy="participants",cascade=CascadeType.ALL)
	private AccomodationRequest accomodationRequest;


	public Participants() {
		
	}
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Double getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Double contactNumber) {
		this.contactNumber = contactNumber;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Participants [id=" + id + ", name=" + name + ", emailId=" + emailId + ", contactNumber=" + contactNumber
				+ ", college=" + college + "]";
	}
	
}
