package frame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
        JLabel name_title = bean.title("用户名:", 0, 0, 100, 35);
        JLabel pass_title = bean.title("密码:", 0, 40, 100, 35);
        JLabel pass_again = bean.title("密码确认:", 0, 80, 100, 35);
        final JLabel msg  = bean.title("密码不对", 250, 40, 90, 35);
        msg.setVisible(false);
        
        final JTextField name = bean.text(100, 0, 150);
        final JPasswordField pass = bean.passwrod(100, 40, 150);
        final JPasswordField pagain = bean.passwrod(100, 80, 150);
        
        JButton login_button = bean.button("注册", 50, 150, 150, 35);
        
        login_button.addActionListener(
            new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					String passs = pass.getText();
					String pasagin = pagain.getText();
					if(passs.equals(pasagin)){
						System.out.println("login......");
						User u = new User();
						u.setName(name.getText());
						u.setPassword(passs);
						
						base.update(u, sdu.SAVE);
						base.allClose();
					}else{
						System.out.println("erorr");
						msg.setVisible(true);
					}
				}
            }
        );
        
        final JFrame login = this.login(name_title,
        		                        pass_title,
        		                        pass_again,
        		                        msg,
        		                        name,
        		                        pass,
        		                        pagain,
        		                        login_button
        		                        );
    }
	
	public JFrame login(Component ... beans){
		JFrame login = new JFrame("注册");
		login.setLayout(null);
		login.setBounds(0, 0, 350, 700);
		
		for(int i=0; i<beans.length; i++){
			login.add(beans[i]);
		}
		
		login.setVisible(true);
		return login;
	}
}
