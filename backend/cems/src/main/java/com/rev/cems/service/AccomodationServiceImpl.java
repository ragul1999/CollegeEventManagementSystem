package com.rev.cems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.cems.dao.AccomodationDaoImpl;
import com.rev.cems.entity.Accomodation;

@Service
@Transactional
public class AccomodationServiceImpl implements AccomodationService {

	@Autowired
	AccomodationDaoImpl accomodationDaoImpl;
	
	@Override
	public Accomodation createAccomodation(Accomodation accomodation) {
		return accomodationDaoImpl.save(accomodation);
	}

	@Override
	public Accomodation getAccomodationById(Long id) {
		return accomodationDaoImpl.findById(id).get();
	}

	@Override
	public List<Accomodation> getAllAccomodation() {
		return accomodationDaoImpl.findAll();
	}

	@Override
	public Accomodation deleteAccomodation(Long id) {
		
		Accomodation ar = accomodationDaoImpl.findById(id).get();
		if(ar!=null)
			accomodationDaoImpl.deleteById(id);
		return ar;
	}

	@Override
	public Accomodation updateAccomodation(Accomodation accomodation) {
		
		boolean b=accomodationDaoImpl.existsById(accomodation.getId());
		Accomodation ar=new Accomodation();
		if(b)
		{
			accomodationDaoImpl.save(accomodation);
			ar=accomodationDaoImpl.findById(accomodation.getId()).get();
		}
		return ar;	
	}

}
