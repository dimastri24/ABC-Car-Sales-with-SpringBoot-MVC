package com.lithan.csp.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Users {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="user_name", nullable = false)
    private String userName;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "pass", nullable = false)
    private String password;
    
    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;
    
    @Column(name = "address", nullable = true)
    private String address;
    
    @ManyToMany
    @JoinTable( name="user_role",
                joinColumns = @JoinColumn(name = "users_id"),
                inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Roles> roles = new HashSet<>();
    
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Cars> cars = new HashSet<Cars>();
    
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<CarBidding> biddings = new HashSet<CarBidding>();
    
    public Users() {}

	public Users(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Users(String userName, String password, Set<Roles> roles) {
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public Users(String name, String userName, String password, String phoneNumber, String address, Set<Roles> roles) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public Set<Cars> getCars() {
		return cars;
	}

	public void setCars(Set<Cars> cars) {
		this.cars = cars;
	}

	public Set<CarBidding> getBiddings() {
		return biddings;
	}

	public void setBiddings(Set<CarBidding> biddings) {
		this.biddings = biddings;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}
    

}
