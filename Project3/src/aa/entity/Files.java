package aa.entity;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.persistence.*;


@Entity
@Table(name="files")
public class Files {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="file_seq")
	@SequenceGenerator(name="file_seq",sequenceName="file_sequence",allocationSize=1)
    private Integer file_id;
	@Column(name="name")
    private String name;
	@Column(name="main")
    private byte[] main;

	
	public Integer getFile_id() {
		return file_id;
	}
	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getMain() {
		return main;
	}
	public void setMain(byte[] main) {
		this.main = main;
	}
	

	
}
