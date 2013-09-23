package frame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.BaseDao;
import db.impl.BaseImpl;
import entity.User;
import bean.Bean;

public class Logon {
	private Bean bean = new Bean();
	
	public Logon(){
		final JLabel name_title = bean.title("用户名:", 80, 30, 90, 35);
		final JLabel pass_title = bean.title("密码:", 80, 85, 90, 35);
		final JLabel msg = bean.title("登陆失败", 180, 110, 90, 35);
		msg.setVisible(false);
		
		final JTextField name = bean.text(152, 30, 200);
		final JPasswordField pass = bean.passwrod(152, 80, 200);
        
		final JButton logon_button = bean.button("登陆", 100, 150, 100, 50);
		final JButton login_button = bean.button("注册", 250, 150, 100, 50);
		
		logon_button.addActionListener(
				new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String nameText = name.getText();
						char[] passWord = pass.getPassword();
						String passText = new String(passWord);
						
						BaseDao base = new BaseImpl();
						String sql = "select * from user where name=? and password=?";
						Object[] value = {nameText,passText};
						User user = new User();
						List<User> list = base.list(sql, value, user);
						for(User u:list){
							System.out.println(u.getName());
						}
						if(list.size()==1){
							System.out.println("登陆成功");
						}else{
							System.out.println("登陆失败");
							msg.setVisible(true);
						}
					}
				}
		);
		login_button.addActionListener(
		    new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					new Login();
				}
		    	
		    }
		);
		
		JFrame jf = logon_frame(name_title,pass_title,name,pass,login_button,logon_button, msg);
		jf.setVisible(true);
		
		
	}
	
    public JFrame logon_frame(Component ... beans){
    	JFrame jf = new JFrame("登陆");
    	jf.setBounds(0,0,450,250);
    	jf.setLayout(null);
    	
    	for(int i=0; i<beans.length; i++){
    		jf.add(beans[i]);
    	}
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	return jf;
    }
}
