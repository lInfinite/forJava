package aa.service.dao;

import java.util.List;


import aa.entity.Mail;
import aa.entity.Users;

public interface MailSericeDao {
    public void saveMail(Mail mail);
    public void updateMail(Mail mail);
    public void deleteMail(Mail mail);
	public Users findUser(String userName);
	public Mail createMail(int id);
	public List<Users> selectUsers();
	public List<Mail> selectMail(int id,int page,int dele);
	public List<Mail> selectDele(int id,int page);
}
