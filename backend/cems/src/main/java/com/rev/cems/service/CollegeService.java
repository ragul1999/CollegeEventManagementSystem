package com.rev.cems.service;

import java.util.List;
import com.rev.cems.entity.College;

public interface CollegeService {

	College createCollege(College college);
	
	College getCollegeById(Long id);
	
	List<College> getAllCollege();

	College deleteCollege(Long id);

	College updateCollege(College college);

	
	
	
}
