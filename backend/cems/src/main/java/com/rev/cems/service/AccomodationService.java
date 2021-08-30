package com.rev.cems.service;

import java.util.List;

import com.rev.cems.entity.Accomodation;

public interface AccomodationService {

	 Accomodation createAccomodation( Accomodation  accomodation) ;
	
	 Accomodation getAccomodationById(Long id);
	
	 List<Accomodation> getAllAccomodation();

	 Accomodation deleteAccomodation(Long id);

	 Accomodation updateAccomodation(Accomodation  accomodation);
}
