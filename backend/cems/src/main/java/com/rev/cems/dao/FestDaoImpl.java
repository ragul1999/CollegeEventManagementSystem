package com.rev.cems.dao;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.cems.entity.Fest;


@Repository
public interface FestDaoImpl extends JpaRepository<Fest,Long> {
	
	
	
	

}
