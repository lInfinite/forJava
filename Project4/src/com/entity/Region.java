package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="project4_region")
public class Region {
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_region_seq")     
	@SequenceGenerator(name="p4_region_seq", sequenceName="project4_region_sequence", allocationSize=1)
    private long id;
	@Column(name="value")
	private String value;
	@OneToMany(mappedBy="region")
	private Set<SellChance> sell_chance;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
