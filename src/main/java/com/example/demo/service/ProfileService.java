package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ContactUs;
import com.example.demo.model.Profile;
import com.example.demo.model.ProfileDetails;
import com.example.demo.repository.ProfileRepo;
import com.example.demo.repository.ProfileRepository;

@Service
public class ProfileService {
	

	@Autowired
	ProfileRepository profileRepo;
	
	@Autowired
	ContactUsService contactUsService;
	
	@Autowired
	ProfileRepo proRepo;
	
	@Transactional
	public Profile saveProfile(Profile profile) {
		contactUsService.saveContactUs(profile.getContactUs());
		profile.getDetails().setId(profile.getId());
		profile.getDetails().setProfile(profile);
		return profileRepo.save(profile);
	}
	
	public ProfileDetails setDetails(Profile profile) {
		ProfileDetails proDetails=new ProfileDetails(
				profile.getId(),
				profile.getDetails().getAboutUs(),
				profile.getDetails().getNoOfBed(),
				profile.getDetails().getIcuBed(),
				profile.getDetails().isPathLab(),
				profile.getDetails().isTrumaFacility(),
				profile.getDetails().isInfectiousDiseaseFacility(),
				profile.getDetails().isPsychiatricFacility(),
				profile.getDetails().isAmbulanceFacility(),
				profile.getDetails().getWebsiteAddress(),
				profile.getDetails().getStatus(),
				profile.getDetails().getBannerUrl(),
				profile.getDetails().getProfile()
				);
		return proDetails;
	}
}
