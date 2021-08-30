package com.rev.cems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.cems.entity.Accomodation;

@Repository
public interface AccomodationDaoImpl extends JpaRepository<Accomodation,Long> {

}
