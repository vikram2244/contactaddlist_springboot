package com.contact.contactlist.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.contact.contactlist.model.ContactPage;
import com.contact.contactlist.model.LoginUser;
import com.contact.contactlist.model.User;

@Service
public interface UserService {
    Boolean isValidUser(LoginUser loginUser);
    User createUser(User user);
    Boolean checkReg(User user);
	ContactPage createContact(ContactPage contactpage);
	String allContacts( String email);
	void deleteUser(String id);
}
