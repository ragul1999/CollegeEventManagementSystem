package com.rev.cems.service;

import java.util.List;

import com.rev.cems.entity.Fest;


public interface FestService {
	  List<Fest> getAllFest();
	  Fest getFestById( Long id);
	  Fest createFest(  Fest fest);
	  Fest updateFest( Long id,  Fest festUpdated);
	  Fest updateDate(Long id, String date); 
	  String deleteFest( Long id);
}
