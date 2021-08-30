package com.rev.cems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.cems.entity.College;

@Repository
public interface CollegeDaoImpl extends JpaRepository<College, Long>{

	
	
}
