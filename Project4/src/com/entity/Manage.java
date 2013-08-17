package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@ManyToMany(mappedBy="manage")
	private Set<Role> role;
	
	
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
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}

	
	
}
