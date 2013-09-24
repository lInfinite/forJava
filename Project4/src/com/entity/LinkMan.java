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
	@Column(name="remarks")
	private String remarks;  //备注
	
}
