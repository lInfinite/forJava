package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**商品**/
@Entity
@Table(name="project4_product")
public class Product {
    
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_product_seq")     
	@SequenceGenerator(name="p4_product_seq", sequenceName="project4_product_sequence", allocationSize=1)
    private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="model")
	private String model;

	@Column(name="level_s")
	private String level;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="money")
	private Float money;
	
	@Column(name="remark")
	private String remark;

	
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
