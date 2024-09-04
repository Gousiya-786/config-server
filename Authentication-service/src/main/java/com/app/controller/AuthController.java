package com.app.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRequest;
import com.app.service.impl.JwtService;


/**
 * Controller for handling authentication-related operations.
 * Provides endpoints for user authentication and token generation.
 */
@RestController
@RequestMapping("/auth")
public class AuthController
{


	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	/**
     * Authenticates the user and generates a JWT token if authentication is successful.
     *
     * @param authRequest Data transfer object containing username and password.
     * @return JWT token if authentication is successful.
     * @throws UsernameNotFoundException if authentication fails.
     */
	 @PostMapping("/authenticate")
	  public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) 
	  {
		  // Authenticate the user with the provided username and password.
	     Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	        
	  // Check if the authentication was successful.
	        if (authentication.isAuthenticated()) 
	        {
	            return jwtService.generateToken(authRequest.getUsername());
	        } 
	        else 
	        {
	        	// Throw exception if authentication fails.
	            throw new UsernameNotFoundException("invalid user request !");
	        }
	  }
	        
}
