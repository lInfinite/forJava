package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**服务类型**/
@Entity
@Table(name="project4_service_type")
public class ServiceType {
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_service_type_seq")     
	@SequenceGenerator(name="p4_service_type_seq", sequenceName="project4_service_type_sequence", allocationSize=1)
    private Long id;
	@Column(name="value")
	private String value;
	
	
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
	
	
}
