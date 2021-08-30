package com.rev.cems.entity;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="Event")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false,length=30)
	private String name;
	
	@Column(nullable=false)
	private String description;
	
	@Column(nullable=false,length=30)
	private String type;
	
	
	@Column(name="max_seats",nullable=false)
	private Integer maxSeats;
	
	@Column(name="avail_seats",nullable=false)
	private Integer availSeats;
	
	@Column(name="contact_mail",nullable=false,length=40)
	private String contactMail;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="event_date",nullable=false)
	private Date eventDate;
	
	
	@Column(name="event_time",nullable=false)
	private LocalTime eventTime;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fest_id", nullable = false)
    private Fest fest;
	
	@OneToMany(mappedBy="event",cascade=CascadeType.ALL)
	private List<EventParticipants> eventParticipants;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(Integer maxSeats) {
		this.maxSeats = maxSeats;
	}

	public Integer getAvailSeats() {
		return availSeats;
	}

	public void setAvailSeats(Integer availSeats) {
		this.availSeats = availSeats;
	}


	public Fest getFest() {
		return fest;
	}

	public void setFest(Fest fest) {
		this.fest = fest;
	}

	public String getContactMail() {
		return contactMail;
	}

	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public LocalTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}

}
