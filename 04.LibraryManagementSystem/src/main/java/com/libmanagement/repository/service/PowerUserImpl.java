package com.libmanagement.repository.service;
import java.util.Optional;

import com.libmanagement.model.PowerUser;
import com.libmanagement.repository.PowerUserRepository;

public class PowerUserImpl implements PowerUserInterface{
	
	PowerUserRepository poweruser;
	@Override
	public PowerUser CreatePowerUser(PowerUser user) {
		
		return poweruser.save(user);
	}
	
	
//	Optional<PowerUser>findByemail(String email){
//		return poweruser.findby
//		
//	}

}
