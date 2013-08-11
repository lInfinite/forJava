package user.manager;

import java.util.Date;

public class Modify {
	//select id AS 编号,sum AS 金额,quantity AS 数量 ,name AS 货品名称,unit AS 金额单位,
	//describe AS 商品描述,payment AS 是否付款,provider AS 供货商,time AS 时间 from project_two_modify; 
 private int id;          //1
 private int sum;         //3
 private int quantity;    //4
 private String type;     //5
 private String name;     //6
 private String describe; //7
 private String payment;  //8
 private String provider; //9
 private Date time;     //10
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}

public int getSum() {
	return sum;
}
public void setSum(int sum) {
	this.sum = sum;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescribe() {
	return describe;
}
public void setDescribe(String describe) {
	this.describe = describe;
}
public String getPayment() {
	return payment;
}
public void setPayment(String payment) {
	this.payment = payment;
}
public String getProvider() {
	return provider;
}
public void setProvider(String provider) {
	this.provider = provider;
}


}
