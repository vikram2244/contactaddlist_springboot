package com.contact.contactlist.Service;

import java.util.List;
import java.util.Optional;

import com.contact.contactlist.model.ContactPage;
import com.contact.contactlist.model.LoginUser;
import com.contact.contactlist.model.User;

public interface UserService {
    Boolean isValidUser(LoginUser loginUser);
    User createUser(User user);
    Boolean checkReg(User user);
	ContactPage createContact(ContactPage contactpage);
	List<ContactPage> allContacts( String email);
	void deleteUser(String id);
}
