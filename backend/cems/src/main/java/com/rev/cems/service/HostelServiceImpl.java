package com.rev.cems.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.cems.dao.HostelDaoImpl;
import com.rev.cems.entity.Hostel;

@Service
@Transactional
public class HostelServiceImpl implements HostelService {

	@Autowired
	HostelDaoImpl hostelDaoImpl;
	
	@Override
	public Hostel createHostel(Hostel hostel) {
		return hostelDaoImpl.save(hostel);
	}

	@Override
	public Hostel getHostelById(Long id) {
		return hostelDaoImpl.findById(id).get();
	}

	@Override
	public List<Hostel> getAllHostel() {
		return hostelDaoImpl.findAll();
	}

	@Override
	public Hostel deleteHostel(Long id) {
		Hostel h = hostelDaoImpl.findById(id).get();
		if(h!=null) 
			hostelDaoImpl.delete(h);
		return h;
	}

	@Override
	public Hostel updateHostel(Hostel hostel) {
		
		boolean b=hostelDaoImpl.existsById(hostel.getId());
		Hostel h=new Hostel();
		if(b)
		{
			hostelDaoImpl.save(hostel);
			h = hostelDaoImpl.findById(hostel.getId()).get();
		}
		return h;
	}

}
