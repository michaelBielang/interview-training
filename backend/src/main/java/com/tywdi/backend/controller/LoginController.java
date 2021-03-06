package com.tywdi.backend.controller;

import com.tywdi.backend.model.User;
import com.tywdi.backend.model.dto.AuthenticationRequest;
import com.tywdi.backend.model.web.JwtTokenResponse;
import com.tywdi.backend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Organisation: Codemerger Ldt.
 * Project: backend
 * Package: com.tywdi.backend.controller
 * Date: 10.08.2020
 *
 * @author: Michael Bielang, b137ang@codemerger.com.
 * @version: java version "14" 2020-03-17
 */

@RestController
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController implements LoginControllerInterface {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    @PostMapping("/login")
    public ResponseEntity<JwtTokenResponse> login(@RequestBody @Valid AuthenticationRequest request) {
        return new ResponseEntity<>(authenticationService.generateJWTToken(request.getEmail(), request.getPassword()),
                HttpStatus.CREATED);
    }

    // TODO - michael.bielang: 01.09.2020 follow up implementation for session based implementation
    @Override
    @GetMapping
    public User getUser(@RequestParam("email") @NotBlank @Email final String email,
                        @RequestParam("password") @NotBlank @Min(5) final String password) {
        return null;
    }
}
