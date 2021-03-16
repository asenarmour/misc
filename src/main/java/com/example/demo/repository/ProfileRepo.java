package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Profile;
import com.example.demo.model.ProfileDetails;

@Repository
public class ProfileRepo {

	@PersistenceContext
	private EntityManager entityManager;

	
	public ProfileDetails saveDetails(Profile profile) {
		Profile pro=entityManager.find(Profile.class, profile.getId());
		ProfileDetails details=new ProfileDetails();
		details.setProfile(pro);
		return details;
	}
	
}
