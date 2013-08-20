package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="project4_clintlevel")
public class ClintLevel {
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_clintlevel_seq")     
	@SequenceGenerator(name="p4_clintlevel_seq", sequenceName="project4_clintlevel_sequence", allocationSize=1)
    private Long id;
	@Column(name="value")
	private String value;
	@OneToMany(mappedBy="clinet_level")
	private Set<SellChance> sell_chance;
	
	
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Set<SellChance> getSell_chance() {
		return sell_chance;
	}
	public void setSell_chance(Set<SellChance> sell_chance) {
		this.sell_chance = sell_chance;
	}

}
