package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="project4_manage")
public class Manage {
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_manage_seq")     
	@SequenceGenerator(name="p4_manage_seq", sequenceName="project4_manage_sequence", allocationSize=1)
	private long id;
	@Column(name="name")
    private String name;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
