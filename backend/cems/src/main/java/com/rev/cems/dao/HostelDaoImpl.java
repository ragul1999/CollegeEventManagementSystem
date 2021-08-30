package com.rev.cems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.cems.entity.Hostel;

@Repository
public interface HostelDaoImpl extends JpaRepository<Hostel,Long> {

}
