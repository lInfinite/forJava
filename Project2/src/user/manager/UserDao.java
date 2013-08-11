package user.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import page.c.Page;

import base.dao.ExecuteSql;

public class UserDao {
	ExecuteSql ex=new ExecuteSql();
	ResultSet rs;
    Page page=new Page();
	
    //增
	public void add(User user){
		String add="INSERT INTO project_two_user VALUES(user_sequence.nextval,?,?,?,?,?,?,?,0)";
		String name=user.getName();
		String sex=user.getSex();
		int age=user.getAge();
		String phone=user.getPhone();
		String address=user.getAddress();
		String type=user.getType();
		String pass=user.getPassword();
		Object[] parameter={name,sex,age,phone,address,type,pass};
		System.out.println("增加用户......");
		ex.change(add, parameter);
		ex.allClose();
	}
	//删
	public void delete(int id){
		String delete="delete from project_two_user where id=?";
		Object[] parameter={id};
		ex.change(delete, parameter);
		ex.allClose();
	}
	//改信息      UPDATE project_two_user SET,name='我辈',age=21,phone=110,address='K隆星',type='用户' where id=1
	public void update(User user){
		String update2="UPDATE project_two_user SET name=? where id=?";
		String update3="UPDATE project_two_user SET age=? where id=?";
		String update4="UPDATE project_two_user SET phone=? where id=?";
		String update5="UPDATE project_two_user SET address=? where id=?";
		String update6="UPDATE project_two_user SET type=? where id=?";
		String update7="UPDATE project_two_user SET sex=? where id=?";
		int id=user.getId();
		String name=user.getName();
		int age=user.getAge();
		String phone=user.getPhone();
		String address=user.getAddress();
		String sex=user.getSex();
		if(name!=null){
		Object[] parameter={name,id};
		ex.change(update2, parameter);
		ex.allClose();
		}
		if(age!=0){
		Object[] parameter={age,id};
		ex.change(update3, parameter);
		ex.allClose();
		}
		if(phone!=null){
		Object[] parameter={phone,id};
		ex.change(update4, parameter);
		ex.allClose();
		}
		if(address!=null){
		Object[] parameter={address,id};
		ex.change(update5, parameter);
		ex.allClose();
		}
		if(sex!=null){
		Object[] parameter={sex,id};
		ex.change(update7, parameter);
		ex.allClose();
		}
	}
	//改密码  
	public void uppass(User user){
		String uppass="UPDATE project_two_user SET password=? where id=?";
		int id=user.getId();
		String pass=user.getPassword();
		Object[] parameter={pass,id};
		ex.change(uppass, parameter);
		ex.allClose();
	}
	//查找修改用户的登陆密码
	public String getPass(int id){
		String pass=null;
		String selectWord="select password from project_two_user where id=?";
		Object[] parameter={id};
		rs=ex.select(selectWord, parameter);
		try {
			while(rs.next()){
				pass=rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		ex.allClose();
		return pass;
	}
	//查  
	public List<User> select(int Nobe,int pageSize){
		String select="select id,name,sex,age,phone,address,type from (select id,name,sex,age,phone,address,type,rownum rn from project_two_user) where rn>=? and rn<=? ";
		List<User> list=new ArrayList();
    	int top=page.top(Nobe, pageSize);
    	int end=page.end(Nobe, pageSize);
		Object[] parameter={top,end};
		rs=ex.select(select, parameter);
		try {
			while(rs.next()){
              int id=rs.getInt("id");
              String name=rs.getString("name");
              String sex=rs.getString("sex");
              int age=rs.getInt("age");
              String phone=rs.getString("phone");
              String address=rs.getString("address");
              String type=rs.getString("type");
              User user=new User();
              user.setId(id);
              user.setName(name);
              user.setSex(sex);
              user.setAge(age);
              user.setPhone(phone);
              user.setAddress(address);
              user.setType(type);
              list.add(user);
			 }
			
		} catch (SQLException e) {
			System.out.println("遍历出错");
			e.printStackTrace();
			ex.allClose();
			return null;
		}
    	ex.allClose();
    	return list;
    }
	//查  
	public List<User> selectLike(int Nobe,int pageSize,String Name){
		String select="select id,name,sex,age,phone,address,type from project_two_user where id>=? and id<=? and name like ?";
		List<User> list=new ArrayList();
		int top=page.top(Nobe, pageSize);
		int end=page.end(Nobe, pageSize);
		Object[] parameter={top,end,Name};
		rs=ex.select(select, parameter);
		try {
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String sex=rs.getString("sex");
				int age=rs.getInt("age");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				String type=rs.getString("type");
				User user=new User();
				user.setId(id);
				user.setName(name);
				user.setSex(sex);
				user.setAge(age);
				user.setPhone(phone);
				user.setAddress(address);
				user.setType(type);
				list.add(user);
			}
			
		} catch (SQLException e) {
			System.out.println("遍历出错");
			e.printStackTrace();
			ex.allClose();
			return null;
		}
		ex.allClose();
		return list;
	}
	
	//判读用户登陆             id,name,type,password
		public boolean login(String name,String pass,HttpServletRequest request){
			String USER="select id,name,type,password from project_two_user";
			Object[] parameter={};
			rs=ex.select(USER, parameter);
			try {
				while(rs.next()){
					int user_id=rs.getInt("id");
					String user_name=rs.getString("name");
					String user_type=rs.getString("type");
					String user_password=rs.getString("password");
				if(name.equals(user_name)&&pass.equals(user_password)){
					request.getSession().setAttribute("user_id", user_id);
					request.getSession().setAttribute("user_name", user_name);
					request.getSession().setAttribute("user_type", user_type);
					request.getSession().setAttribute("user_password", user_password);
					return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
			return false;
		} 
	
    // 查看登录状态
		public int getLogin(int sessionID){
			String getLogin="select login from project_two_user where id=?";
			Object[] parameter={sessionID};
			rs=ex.select(getLogin, parameter);
			int login=1;
			try {
				while(rs.next()){
					login=rs.getInt("login");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return 1;
			}
			ex.allClose();
			return login;
		}
   //  设置登录状态
		public void setLogin(int login,int sessionID){
			String setLogin="UPDATE project_two_user SET login=? where id=?";
			Object[] parameter={login,sessionID};
			ex.change(setLogin, parameter);
			ex.allClose();
		}
		public int all(){
			int a=0;
			String count="SELECT count(*) from project_two_user";
	    	Object[] params={};
	    	ResultSet rs=ex.select(count, params);
	    	try {
				while(rs.next()){
					a=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return a;
		}
	
}
