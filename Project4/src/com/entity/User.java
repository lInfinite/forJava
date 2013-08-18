package com.entity;

import java.util.Set;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="project4_user")
public class User {
	@Id
	@GeneratedValue(strategy=SEQUENCE,generator="p4_user_seq")     
	@SequenceGenerator(name="p4_user_seq",sequenceName="project4_user_sequence",allocationSize=1)
    private long id;
	@Column(name="name")
    private String name;
	
	@Column(name="password")
    private String password;
	
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
    
    
}
