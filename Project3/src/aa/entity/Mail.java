package aa.entity;

import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="mail")
public class Mail {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mail_seq")
	@SequenceGenerator(name="mail_seq",sequenceName="mail_sequence",allocationSize=1)
    private Integer id;
	@Column(name="send_id")
    private Integer send_id;
	@Column(name="send_name")
	private String send_name;
	@Column(name="read_id")
    private Integer read_id;
	@Column(name="title")
    private String title;
	@Lob
	@Column(name="text")
    private String text;
	@Column(name="read")
    private String read;
	@Column(name="dele")
    private Integer dele;
    @Column(name="time")
	private String time;
    @OneToOne
    @JoinColumn(name="file_id")
	private Files file;
    
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getSend_id() {
		return send_id;
	}
	
	public void setSend_id(Integer send_id) {
		this.send_id = send_id;
	}
	
	
	public Integer getRead_id() {
		return read_id;
	}
	
	public void setRead_id(Integer read_id) {
		this.read_id = read_id;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	
	public Integer getDele() {
		return dele;
	}
	public void setDele(Integer dele) {
		this.dele = dele;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Files getFile() {
		return file;
	}
	public void setFile(Files file) {
		this.file = file;
	}
	public String getSend_name() {
		return send_name;
	}
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	
}
