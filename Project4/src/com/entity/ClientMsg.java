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

/**
 * 客户信息
 * */

@Entity
@Table(name="project4_client_msg")
public class ClientMsg {
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="p4_sclient_msg_seq")     
	@SequenceGenerator(name="p4_client_msg_seq", sequenceName="project4_client_msg_sequence", allocationSize=1)
	private Long id;                         //ID
	
	@Column(name="client_credit")
	private String client_credit;            //客户信誉度
	
	@Column(name="client_satisfaction")
	private String client_satisfaction;      //客户满意度
	
	@Column(name="address")
	private String address;                  //地址
	
	@Column(name="postalcode")
	private int postalcode;                  //邮政编码
	
	@Column(name="phone")
	private String phone;                    //电话
	
	@Column(name="fax")
	private String fax;                      //传真
	
	@Column(name="url")
	private String url;                      //网址
	
	@Column(name="business_license")
	private String business_license;         //营业执照注册号
	
	@Column(name="legal_man")
	private String legal_man;                //法人
	
	@Column(name="registered_capital")
	private int registered_capital;          //注册资金
	
	@Column(name="year_money")
	private int year_money;                  //年度业额
	
	@Column(name="deposit_bank")
	private String deposit_bank;             //开户银行
	
	@Column(name="bank_account")
	private String bank_account;             //开户账号
	
	@Column(name="government_rent")
	private String government_rent;          //地税登记号
	
	@Column(name="national_tax")
	private String national_tax;             //国税登记号
    
	@OneToOne(mappedBy="client_msg")
	@JoinColumn(name="sell_chance_id")
	private SellChance sell_chance;          //与sellchuance里的客户为一对一的关系

	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClient_credit() {
		return client_credit;
	}

	public void setClient_credit(String client_credit) {
		this.client_credit = client_credit;
	}

	public String getClient_satisfaction() {
		return client_satisfaction;
	}

	public void setClient_satisfaction(String client_satisfaction) {
		this.client_satisfaction = client_satisfaction;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBusiness_license() {
		return business_license;
	}

	public void setBusiness_license(String business_license) {
		this.business_license = business_license;
	}

	public String getLegal_man() {
		return legal_man;
	}

	public void setLegal_man(String legal_man) {
		this.legal_man = legal_man;
	}

	public int getRegistered_capital() {
		return registered_capital;
	}

	public void setRegistered_capital(int registered_capital) {
		this.registered_capital = registered_capital;
	}

	public int getYear_money() {
		return year_money;
	}

	public void setYear_money(int year_money) {
		this.year_money = year_money;
	}

	public String getDeposit_bank() {
		return deposit_bank;
	}

	public void setDeposit_bank(String deposit_bank) {
		this.deposit_bank = deposit_bank;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}

	public String getGovernment_rent() {
		return government_rent;
	}

	public void setGovernment_rent(String government_rent) {
		this.government_rent = government_rent;
	}

	public String getNational_tax() {
		return national_tax;
	}

	public void setNational_tax(String national_tax) {
		this.national_tax = national_tax;
	}

	public SellChance getSell_chance() {
		return sell_chance;
	}

	public void setSell_chance(SellChance sell_chance) {
		this.sell_chance = sell_chance;
	}
	
	
	
}
