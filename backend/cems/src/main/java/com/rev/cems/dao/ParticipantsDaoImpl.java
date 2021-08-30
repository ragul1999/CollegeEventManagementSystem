package com.rev.cems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.cems.entity.Participants;

@Repository
public interface ParticipantsDaoImpl extends JpaRepository<Participants, Long> {

}
