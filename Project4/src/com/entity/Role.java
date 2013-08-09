package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="project4_role")
public class Role {
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_role_seq")     
	@SequenceGenerator(name="p4_role_seq", sequenceName="project4_role_sequence", allocationSize=1)
    private long id;
	@Column(name="name")
    private String name;
	@Column(name="manage")
    private String manage;
	@ManyToMany
	@JoinTable(
	    name="role_and_user",
	    joinColumns={ @JoinColumn(name="role_id")},
	    inverseJoinColumns={ @JoinColumn(name="user_id")}
	)
	private Set<User> user;
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
	public String getManage() {
		return manage;
	}
	public void setManage(String manage) {
		this.manage = manage;
	}
    
}
