package com.libmanagement.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.libmanagement.model.AuthenticationResponse;
import com.libmanagement.model.PowerUser;
import com.libmanagement.repository.service.AuthenticationService;

@CrossOrigin
@RestController
public class AuthenticationController {
	
	 private final AuthenticationService authService;

	    public AuthenticationController(AuthenticationService authService) {
		super();
		this.authService = authService;
	}

		@PostMapping("/register")
	    public ResponseEntity<PowerUser> register(
	            @RequestBody PowerUser request
	            ) {
	    	
	        return ResponseEntity.ok(authService.register(request));
	    }

	    @PostMapping("/login")
	    public ResponseEntity<AuthenticationResponse> login(@RequestBody PowerUser request) {
	    	System.out.println(request.getEmail());
	        return ResponseEntity.ok(authService.authentice(request));
	    }

}
