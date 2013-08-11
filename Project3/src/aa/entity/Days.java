package aa.entity;


import javax.persistence.*;


@Entity
@Table(name="days")
public class Days {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="day_seq")
	@SequenceGenerator(name="day_seq",sequenceName="day_sequence",allocationSize=1)
    private Integer id;
	@Column(name="name_id")
    private Integer name_id;
	@Column(name="name")
	private String name;
	@Column(name="top")
    private String topTime;
	@Column(name="end")
    private String endTime;
	@Column(name="days")
    private Integer days;
	@Column(name="cause")
    private String cause;
	@Column(name="read_id")
    private Integer read_id;
	@Column(name="status")
    private String status;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getName_id() {
		return name_id;
	}
	public void setName_id(Integer name_id) {
		this.name_id = name_id;
	}
	

	
	public String getTopTime() {
		return topTime;
	}
	public void setTopTime(String topTime) {
		this.topTime = topTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public Integer getRead_id() {
		return read_id;
	}
	public void setRead_id(Integer read_id) {
		this.read_id = read_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
