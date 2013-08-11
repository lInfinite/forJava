package aa.entity;

import javax.persistence.*;


@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
	@SequenceGenerator(name="user_seq",sequenceName="users_sequence",allocationSize=1)
    private Integer id;
	@Column(name="name")
    private String name;
	@Column(name="password")
    private String password;
	@Column(name="names")
	private String names;
	@Column(name="age")
    private Integer age;
	@Column(name="sex")
    private String sex;
	@Column(name="phone")
    private String phone;
	@Column(name="address")
    private String address;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNames(){
		return names;
	}
	public void setNames(String names){
		this.names = names;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
