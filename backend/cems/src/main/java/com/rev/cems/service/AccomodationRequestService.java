package com.rev.cems.service;

import java.util.List;

import com.rev.cems.entity.AccomodationRequest;

public interface AccomodationRequestService {

	 AccomodationRequest createAccomodationRequest( AccomodationRequest  accomodationRequest) ;
	
	 AccomodationRequest getAccomodationRequestById(Long id);
	
	 List< AccomodationRequest> getAllAccomodationRequest();

	 AccomodationRequest deleteAccomodationRequest(Long id);

	 AccomodationRequest updateAccomodationRequest( String status,Long id);
	
	 
	
}
