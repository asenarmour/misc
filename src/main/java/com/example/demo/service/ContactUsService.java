package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ContactUs;
import com.example.demo.model.Phone;
import com.example.demo.repository.ContactUsRepository;

@Service
public class ContactUsService {

	@Autowired
	ContactUsRepository contactUsRepo;
	
	
	@Transactional
	public ContactUs saveContactUs(ContactUs contactUs) {
		List<Phone> ph=contactUs.getPhone();
		ph.forEach(p->p.setContact(contactUs));

		return contactUsRepo.save(contactUs);
	}
	
	public Optional<ContactUs> getContactUs(Long id) {
		return contactUsRepo.findById(id);
	}
	
	public void deleteContact(Long id) {
		contactUsRepo.deleteById(id);
	}

	
	public ContactUs updateContacts(Long id,ContactUs contactUs) {
		ContactUs cUs=new ContactUs(
				id,
				contactUs.getEmail(),
				contactUs.getAddressLine1(),
				contactUs.getPhone(),
				contactUs.getProfile()
				);
		return saveContactUs(cUs);
	}

	
}
