package com.contact.contactlist.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.contact.contactlist.model.ContactPage;

@Repository
public interface ContactRepo extends JpaRepository<ContactPage, String> { // Changed Integer to String

    @Query("SELECT c FROM ContactPage c WHERE c.email = :email")
    List<ContactPage> findByEmailId(@Param("email") String email);

    void deleteAllById(String id);
}

