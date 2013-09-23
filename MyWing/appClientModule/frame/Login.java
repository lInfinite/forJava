package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.BaseDao;
import db.impl.BaseImpl;
import db.impl.BaseUtil.sdu;
import entity.User;
import bean.Bean;

public class Login {
    
	public Login(){
		final Bean bean = new Bean();
		final BaseDao base = new BaseImpl();
        
        JLabel name_title = bean.title("用户名:", 30, 10, 100, 35);
        JLabel pass_title = bean.title("密码:", 30, 50, 100, 35);
        JLabel pass_again = bean.title("密码确认:", 30, 90, 100, 35);
        final JLabel hasName  = bean.title("已有此名", 270, 10, 90, 35);
        final JLabel erorr  = bean.title("密码有误", 270, 70, 90, 35);
        final JLabel right  = bean.title("注册成功", 270, 70, 90, 35);
        erorr.setVisible(false);
        right.setVisible(false);
        hasName.setVisible(false);
        
        final JTextField name = bean.text(110, 10, 150);
        final JPasswordField pass = bean.passwrod(110, 50, 150);
        final JPasswordField pagain = bean.passwrod(110, 90, 150);
        
        JButton login_button = bean.button("注册", 190, 140, 150, 35);
        JButton back = bean.button("返回", 20, 140, 150, 35);
        
        final JFrame login = bean.frame("注册", 320, 220, 370, 230, name_title,
							        		                         pass_title,
							        		                         pass_again,
							        		                         right,
							        		                         erorr,
							        		                         name,
							        		                         pass,
							        		                         pagain,
							        		                         login_button,
							        		                         back,
							        		                         hasName
							        		                         );
        login.setVisible(true);
        
        login_button.addActionListener(
                new ActionListener(){
    				public void actionPerformed(ActionEvent arg0) {
    					String names = name.getText();
    					String passs = pass.getText();
    					String pasagin = pagain.getText();
    					if(!names.equals("") && !passs.equals("")){
    						if(passs.equals(pasagin)){
    							erorr.setVisible(false);
	    						if(hasName(names)==false){
	    							hasName.setVisible(false);
	    							User u = new User();
	    							u.setName(name.getText());
	    							u.setPassword(passs);
	    							base.update(u, sdu.SAVE);
	    							base.allClose();
	    							login.setVisible(false);
	    							new Logon();
	    						}else{
	    							hasName.setVisible(true);
	    						}
    						}else{
    							erorr.setVisible(true);
    						}
    					}else{
    						erorr.setVisible(true);
    					}
    				}
    				
    				public boolean hasName(String name){
    					BaseDao base = new BaseImpl();
    					String sql = "select * from user where name=?";
    					Object[] value = {name};
    					ResultSet result = base.query(sql, value);
    					int i = 0;
    					try {
    						while(result.next()){
    							i++;
    						}
    						base.allClose();
    						return i!=0;
    					} catch (SQLException e) {
    						e.printStackTrace();
    						return false;
    					}
    				}
                }
            );
        back.addActionListener(
            new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					login.setVisible(false);
					new Logon();
				}
            }
        );
    }
	
}
