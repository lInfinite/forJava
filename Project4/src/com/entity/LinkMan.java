package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.*;

@Entity
@Table(name="project4_linkman")
public class LinkMan {
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_linkman_seq")     
	@SequenceGenerator(name="p4_linkman_seq", sequenceName="project4_linkman_sequence", allocationSize=1)
	private Long id;         //id
	@Column(name="name")
	private String name;     //名称
	@Column(name="sex")
	private String sex;      //性别
	@Column(name="prosition")
	private String position; //职位
	@Column(name="phone")
	private String phone;    //电话
	@Column(name="call")
	private String call;
	@Column(name="remarks")
	private String remarks;  //备注
	@ManyToOne
	@JoinColumn(name="sell_chance")
	private SellChance sell_chance;
	
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public SellChance getSell_chance() {
		return sell_chance;
	}
	public void setSell_chance(SellChance sell_chance) {
		this.sell_chance = sell_chance;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	
	
	
}
