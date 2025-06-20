package com.contact.contactlist.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.contact.contactlist.Repository.ContactRepo;
import com.contact.contactlist.Repository.UserRepo;
import com.contact.contactlist.Service.UserService;
import com.contact.contactlist.model.ContactPage;
import com.contact.contactlist.model.LoginUser;
import com.contact.contactlist.model.User;

@Service
public class ServiceImp implements UserService {

	
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ContactRepo contactRepo;
    
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }
    String user_email;

    @Override
    public Boolean isValidUser(LoginUser loginUser) {
        if (loginUser == null || loginUser.getEmailLogin() == null || loginUser.getPasswordLogin() == null) {
            throw new IllegalArgumentException("Email and password must not be null.");
        }

        Optional<User> user = userRepo.findById(loginUser.getEmailLogin());
        if (user.isEmpty()) {
            return false;
        }
        User foundUser = user.get();
        return foundUser.getPassword().equals(loginUser.getPasswordLogin());
    }


	@Override
	public Boolean checkReg(User user) {
	    if (user == null || user.getEmail() == null) {
	        System.out.println("Invalid user or email provided.");
	        return false;
	    }

	    boolean emailExists = userRepo.findById(user.getEmail()).isPresent();
	    if (emailExists) {
	        System.out.println("Email is found: " + user.getEmail());
	    }
	    return emailExists;
	}
	@Override
    public String allContacts(String email) {
        List<ContactPage> contacts = contactRepo.findByEmailId(email);
        if (!contacts.isEmpty()) {
            user_email = email; 
        } else {
            user_email = null; 
        }
        contacts.forEach(System.out::println);
        return contacts.toString();
    }


	@Override
	public ContactPage createContact(ContactPage contactPage) {
//	    if (contactPage.getEmail() == null || contactPage.getEmail().isEmpty()) {
//	        throw new IllegalArgumentException("Email must not be null or empty.");
//	    }
	    return contactRepo.save(contactPage);
	}


	@Override
	public void deleteUser(String id) {
	    if (id == null || id.isEmpty()) {
	        throw new IllegalArgumentException("ID must not be null or empty.");
	    }
	    if (!contactRepo.existsById(id)) {
	        throw new IllegalArgumentException("Contact with ID " + id + " does not exist.");
	    }
	    contactRepo.deleteById(id);
	}




    
}
