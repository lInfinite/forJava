package user.manager;

import java.util.Date;

public class Modify {
	//select id AS ���,sum AS ���,quantity AS ���� ,name AS ��Ʒ����,unit AS ��λ,
	//describe AS ��Ʒ����,payment AS �Ƿ񸶿�,provider AS ������,time AS ʱ�� from project_two_modify; 
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
