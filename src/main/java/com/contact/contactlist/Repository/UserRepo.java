package com.contact.contactlist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.contactlist.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
