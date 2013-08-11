package aa.web.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.hibernate.Session;

import aa.entity.Files;
import aa.entity.Mail;
import aa.entity.Users;
import aa.service.dao.impl.FilesSericeImpl;
import aa.service.dao.impl.MailSericeImpl;
import aa.uitl.StaticHibernate;

import com.opensymphony.xwork2.ActionSupport;

public class MailAction extends ActionSupport {
	//实体类和操作类
	private Mail mail;
	private Files file;
	private MailSericeImpl msi;
	private FilesSericeImpl fsi;
	//上传
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	//页面交互
    private int page = 0;
    private int goPage;
    private int backPage;
    private List<Users> user_list;
    private List<Mail> mail_check;
    private List<Mail> mail_dele;
    private int mail_id = 0;
    private int list_id;
    private int userId;
    private int dele;
    private InputStream is;
    
    public String send(){
		List<Users> list = msi.selectUsers();
		user_list = list;
    	return "send";
    }

    
    public String sendMail(){
    	if(mail.getTitle().equals("") || mail.getTitle()==null){
    		this.addFieldError("TitleErorr", "标题不能为空");
    		return "send";
    	}
    	
	        if(upload!=null){    	
		    	byte[] upload_byte = fsi.changeBytes(upload);
		    	file.setName(uploadFileName);
		    	file.setMain(upload_byte);
		    	fsi.saveFiles(file);
		    	mail.setFile(file);
	        }
        mail.setTime(StaticHibernate.getNowTime());
    	mail.setRead("未读");
		mail.setDele(0);
		msi.saveMail(mail);
		this.addActionMessage("提交成功");
    	return "send";
    }
    
    
    public String check(){
    	mail_check = msi.selectMail(userId,page,0);
    	return "checkMail";
    }
    
    
    public String one(){
    	mail = msi.createMail(mail_id);
    	return "oneMail";
    }
    
    
    public String maildelete(){
    	mail_dele = msi.selectMail(userId, page,1);
    	return "gotoDelete";
    }
    
    public String dele(){
    	mail = msi.createMail(mail_id);
    	mail.setDele(dele);
    	msi.updateMail(mail);
    	if(dele == 0){
    		System.out.println("checkMail: "+dele);
    	    return "checkMail";
    	}else{
    		System.out.println("gotoDelete: "+dele);
    		return "gotoDelete";
    	}
    }
    
    
    public String delete(){
        mail = msi.createMail(mail_id);
        Files f = mail.getFile();
        if(f!=null){
	        file.setFile_id(f.getFile_id());
	        fsi.deleteFiles(file);
        }
        msi.deleteMail(mail);
    	return "checkMail";
    }
    
    public String download(){
    	Files file = msi.createMail(mail_id).getFile();
    	byte[] b= file.getMain();
    	is=new ByteArrayInputStream(b); 
    	return "download";
    }
    
    
    
    /**
     * getter and setter
     * */
	public Mail getMail() {
		return mail;
	}
	
	public void setMail(Mail mail) {
		this.mail = mail;
	}

	
	public MailSericeImpl getMsi() {
		return msi;
	}
	
	public void setMsi(MailSericeImpl msi) {
		this.msi = msi;
	}


	public List<Users> getUser_list() {
		return user_list;
	}

	public void setUser_list(List<Users> user_list) {
		this.user_list = user_list;
	}


	public Files getFile() {
		return file;
	}

	public void setFile(Files file) {
		this.file = file;
	}

	
	public FilesSericeImpl getFsi() {
		return fsi;
	}

	public void setFsi(FilesSericeImpl fsi) {
		this.fsi = fsi;
	}


	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}


	public List<Mail> getMail_check() {
		return mail_check;
	}


	public void setMail_check(List<Mail> mail_check) {
		this.mail_check = mail_check;
	}


	public List<Mail> getMail_dele() {
		return mail_dele;
	}


	public void setMail_dele(List<Mail> mail_dele) {
		this.mail_dele = mail_dele;
	}


	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getGoPage() {
		/*return goPage;*/
		return page+StaticHibernate.maxPage;
	}
	public void setGoPage(int goPage) {
		this.goPage = goPage;
	}
	
	public int getBackPage() {
		/*return backPage;*/
		return page-StaticHibernate.maxPage;
	}
	public void setBackPe(int backPage) {
		this.backPage = backPage;
	}


	public int getList_id() {
		return list_id;
	}


	public void setList_id(int list_id) {
		this.list_id = list_id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getMail_id() {
		return mail_id;
	}


	public void setMail_id(int mail_id) {
		this.mail_id = mail_id;
	}


	public int getDele() {
		return dele;
	}


	public void setDele(int dele) {
		this.dele = dele;
	}


	public InputStream getIs() {
		return is;
	}


	public void setIs(InputStream is) {
		this.is = is;
	}

	
}
