package com.tywdi.backend.controller;

import com.tywdi.backend.model.User;
import com.tywdi.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value = "/login")
@Validated
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public User getUser(@RequestParam("email") @NotBlank @Email final String email,
                        @RequestParam("password") @NotBlank @Min(5) final String password) {
        return userService.getUser(email, password);
    }
}