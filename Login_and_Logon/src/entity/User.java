package entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import util.UtilForMe;


@Entity
@Table(name="table_user")
public class User {
    @Id
    @GeneratedValue(generator = "user_id")     
    @GenericGenerator(name = "user_id", strategy = "assigned")
	private String id;
	@Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
    
    
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		this.password = UtilForMe.eccryptForSHA1(password);
	}
    
    
    
}
