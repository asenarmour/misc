package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Profile;
import com.example.demo.service.ProfileService;

@RestController
public class ProfileController {

	@Autowired
	ProfileService profileService;
	
	@PostMapping("/profile")
	public Profile saveProfile(@RequestBody Profile profile) {
		return profileService.saveProfile(profile);
	}
}
