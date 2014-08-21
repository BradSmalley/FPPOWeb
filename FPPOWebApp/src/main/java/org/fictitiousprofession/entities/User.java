package org.fictitiousprofession.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@NamedQueries({
	@NamedQuery(name = "User.findUserByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
})
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Length(min = 1, max = 45, message="Username must be between 1 and 45 characters.")
	private String username		= "";
	private String password		= "";
	
	@Length(min = 1, max = 45, message="Username must be between 1 and 45 characters.")
	@Email
	private String email;
	
	@Length(min = 1, max = 45, message="Username must be between 1 and 45 characters.")
	private String lastname;
	
	@Length(min = 1, max = 45, message="Username must be between 1 and 45 characters.")
	private String firstname;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "user")
	private List<Role> roles				= new ArrayList<Role>();
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "user")
	private List<Address> addresses			= new ArrayList<Address>();
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "user")
	private List<PhoneNumber> phoneNumbers	= new ArrayList<PhoneNumber>();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registration_date", nullable = false)
	private Date registrationDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "last_payment_date")
	private Date lastPaymentDate;
	private Boolean paid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Date getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	public Boolean getPaid() {
		return paid;
	}
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	
	public boolean isAdminRole() {
		for (Role r : getRoles()) {
			if (r.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
				return true;
			}
		}
		return false;
	}
}
