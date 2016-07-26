package com.teaching.strategies.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Person Entity class for persistent data Store
 * 
 * 
 * @author srowley
 *
 */
@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table (name="Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String firstName;
    
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String lastName;

    @NotNull
    @Size(min = 2, max = 2)
    private String country;

    @Column(name = "ip_address")
    private String ipAddress;


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String lastName) {
        this.lastName = lastName;
    }

    public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
