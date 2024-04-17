package com.libmanagement.repository.service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.libmanagement.model.AuthenticationResponse;
import com.libmanagement.model.PowerUser;
import com.libmanagement.repository.PowerUserRepository;
@Service
public class AuthenticationService {
	private final PowerUserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final Jwtservice jwtservice;
	private final AuthenticationManager authenticationManager;
	
	
	public AuthenticationService(PowerUserRepository repository, PasswordEncoder passwordEncoder, Jwtservice jwtservice,
			AuthenticationManager authenticationManager) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.jwtservice = jwtservice;
		this.authenticationManager = authenticationManager;
	}
	public PowerUser register(PowerUser request) {
		PowerUser poweruser = new PowerUser();
		poweruser.setEmail(request.getEmail());
		poweruser.setPassword(passwordEncoder.encode(request.getPassword()));
		poweruser.setPassReset(request.getPassReset());
//		poweruser.setAdminData(request.getAdminData());
		poweruser = repository.save(poweruser);
				
//				user.setFirstname(request.getFirstname());
//		user.setLastname(request.getLastname());
//		user.setUsername(request.getUsername());
//		user.setPassword(passwordEncoder.encode(request.getPassword()));
//		user.setRole(request.getRole());
//		user = repository.save(user);
		
//		String token = jwtservice.generateToken(user);
		
		return poweruser;
		//create authenticationresponse in model package
	}
	public AuthenticationResponse authentice(PowerUser request) {
		System.out.println(request.getEmail());
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
					request.getEmail(),
					request.getPassword()
					)
				);
		}
		catch(Exception ae) {
			System.out.println("error at login"+ae.getMessage());
		}
	
		System.out.println("before finding");
		PowerUser user =repository.findByEmail(request.getEmail()).orElseThrow();
		System.out.println("after user");
		System.out.println(user);
		System.out.println(user.getEmail());
		String token = jwtservice.generateToken(user);
		System.out.println(token);
		return new AuthenticationResponse(token);
		
	}
}
