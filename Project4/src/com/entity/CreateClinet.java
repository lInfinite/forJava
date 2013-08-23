package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.*;


@Entity
@Table(name="createclinet")
public class CreateClinet {
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_createclinet_seq")     
	@SequenceGenerator(name="p4_createclinet_seq", sequenceName="project4_createclinet_sequence", allocationSize=1)
    private Long id;
	
	@Column(name="time")
    private String time;
	
	@Column(name="project")
    private String project;
	
	@Column(name="effect")
    private String effect;
	
	@ManyToOne
	@JoinColumn(name="sell_chance_id")
    private SellChance sell_chance;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public SellChance getSell_chance() {
		return sell_chance;
	}
	public void setSell_chance(SellChance sell_chance) {
		this.sell_chance = sell_chance;
	}
    
    
}
