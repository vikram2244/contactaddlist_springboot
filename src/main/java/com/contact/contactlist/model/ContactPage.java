package com.contact.contactlist.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacts")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactPage {

    @Id
    private String id; // Change from Long to String for UUID compatibility

    private String email;
    private Long phone_Number;
    private String name;
    private Date date;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(Long phone_Number) {
		this.phone_Number = phone_Number;
	}

	public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
