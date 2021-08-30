package com.rev.cems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.cems.dao.AccomodationRequestDaoImpl;
import com.rev.cems.entity.AccomodationRequest;

@Service
@Transactional
public class AccomodationRequestServiceImpl implements AccomodationRequestService{

	@Autowired
	AccomodationRequestDaoImpl accomodationRequestDaoImpl; 
	
	
	@Override
	public AccomodationRequest createAccomodationRequest(AccomodationRequest accomodationRequest) {
	
	return accomodationRequestDaoImpl.save(accomodationRequest);
	
	}
	
	@Override
	public AccomodationRequest deleteAccomodationRequest(Long id) {
		AccomodationRequest ar = accomodationRequestDaoImpl.findById(id).get();
		if(ar!=null)
			accomodationRequestDaoImpl.deleteById(id);
			return ar;
	
	}
	
	
	
	@Override
	public List<AccomodationRequest> getAllAccomodationRequest() {
		return accomodationRequestDaoImpl.findAll();
	}
	
	
	@Override
	public AccomodationRequest getAccomodationRequestById(Long id) {
		return accomodationRequestDaoImpl.findById(id).get();
	}
	
	@Override
	public AccomodationRequest updateAccomodationRequest(String status,Long id) {
	
		
		AccomodationRequest ar=accomodationRequestDaoImpl.getById(id);
		
		if(ar!=null)
		{
			ar.setStatus(status);
			accomodationRequestDaoImpl.save(ar);
			ar=accomodationRequestDaoImpl.findById(ar.getId()).get();
		}
		return ar;	
	}
	
	
	
	
	
}
