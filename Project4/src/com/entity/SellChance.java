package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="project4_sellchance")
public class SellChance {
	
	
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_sellchance_seq")     
	@SequenceGenerator(name="p4_sellchance_seq", sequenceName="project4_sellchance_sequence", allocationSize=1)
    private Long id;
	
	@Column(name="clinet_name")
    private String clinet_name;
	
	@ManyToOne
	@JoinColumn(name="clinet_level")
    private ClintLevel clinet_level;
	
	@ManyToOne
	@JoinColumn(name="region")
    private Region region;
	
	@Column(name="chance_from")
    private String chance_from;
	
	@Column(name="odds")
    private String odds;
	
	@Column(name="charge")
    private String charge;
	
	@Column(name="phone")
    private String phone;
	
	@Column(name="summary")
    private String summary;
	
	@Column(name="chance_describe")
    private String chance_describe;
	
	@OneToOne
	@JoinColumn(name="clinet_manage")
    private User clinet_manage;
	
	@Column(name="appoint_time")
    private String appoint_time;
	
	@Column(name="state")
    private String state;
	
	@OneToOne
	@JoinColumn(name="create_man")
    private User create_man;
	
    @OneToMany(mappedBy="sell_chance", fetch=FetchType.EAGER)
    private Set<CreateClinet> create_clinet;
    
    
    
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClinet_name() {
		return clinet_name;
	}
	public void setClinet_name(String clinet_name) {
		this.clinet_name = clinet_name;
	}
	public ClintLevel getClinet_level() {
		return clinet_level;
	}
	public void setClinet_level(ClintLevel clinet_level) {
		this.clinet_level = clinet_level;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public String getChance_from() {
		return chance_from;
	}
	public void setChance_from(String chance_from) {
		this.chance_from = chance_from;
	}
	public String getOdds() {
		return odds;
	}
	public void setOdds(String odds) {
		this.odds = odds;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getChance_describe() {
		return chance_describe;
	}
	public void setChance_describe(String chance_describe) {
		this.chance_describe = chance_describe;
	}
	public User getClinet_manage() {
		return clinet_manage;
	}
	public void setClinet_manage(User clinet_manage) {
		this.clinet_manage = clinet_manage;
	}
	public String getAppoint_time() {
		return appoint_time;
	}
	public void setAppoint_time(String appoint_time) {
		this.appoint_time = appoint_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public User getCreate_man() {
		return create_man;
	}
	public void setCreate_man(User create_man) {
		this.create_man = create_man;
	}
	public Set<CreateClinet> getCreate_clinet() {
		return create_clinet;
	}
	public void setCreate_clinet(Set<CreateClinet> create_clinet) {
		this.create_clinet = create_clinet;
	}


    
}
