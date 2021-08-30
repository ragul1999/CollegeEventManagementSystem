package com.rev.cems.service;

import java.util.List;

import com.rev.cems.entity.Hostel;

public interface HostelService {

	Hostel createHostel(Hostel hostel) ;
	
	Hostel getHostelById(Long id);
	
	List<Hostel> getAllHostel();

	Hostel deleteHostel(Long id);

	Hostel updateHostel(Hostel hostel);
}
