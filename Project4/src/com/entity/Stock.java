package com.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**库存**/
@Entity
@Table(name="project4_stock")
public class Stock {
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_stock_seq")     
	@SequenceGenerator(name="p4_stock_seq", sequenceName="project4_stock_sequence", allocationSize=1)
    private Long id;
	
	@OneToOne
	@JoinColumn(name="product")
	private Product product;
	
	@Column(name="repositories")
	private String repositories;
	
	@Column(name="cargo_space")
	private String cargo_space;
	
	@Column(name="number_s")
	private int number;
	
	@Column(name="remark")
	private String remark;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getRepositories() {
		return repositories;
	}

	public void setRepositories(String repositories) {
		this.repositories = repositories;
	}

	public String getCargo_space() {
		return cargo_space;
	}

	public void setCargo_space(String cargo_space) {
		this.cargo_space = cargo_space;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
