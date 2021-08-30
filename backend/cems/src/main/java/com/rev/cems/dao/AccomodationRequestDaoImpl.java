package com.rev.cems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.cems.entity.AccomodationRequest;

@Repository
public interface AccomodationRequestDaoImpl extends JpaRepository<AccomodationRequest,Long>  {

}
