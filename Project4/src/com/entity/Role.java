package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.*;
/**角色**/
@Entity
@Table(name="project4_role")
public class Role {
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_role_seq")     
	@SequenceGenerator(name="p4_role_seq", sequenceName="project4_role_sequence", allocationSize=1)
    private Long id;
	
	@Column(name="name")
    private String name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		    name="project4_role_and_manage",
		    joinColumns={ @JoinColumn(name="role_id")},
		    inverseJoinColumns={ @JoinColumn(name="manage_id")}
		)
    private Set<Manage> manage;
	
	@OneToMany(mappedBy="role")
	private Set<User> user;

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

	public Set<Manage> getManage() {
		return manage;
	}

	public void setManage(Set<Manage> manage) {
		this.manage = manage;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
	
    

    
}
