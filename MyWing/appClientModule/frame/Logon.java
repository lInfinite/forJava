package frame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bean.Bean;

public class Logon {
	private Bean bean = new Bean();
	
	public Logon(){
		//����
		final JLabel name_title = bean.title("�û���:", 80, 30, 90, 35);
		final JLabel pass_title = bean.title("����:", 80, 85, 90, 35);
		//�����
		final JTextField name = bean.text(152, 30, 200);
		final JPasswordField pass = bean.passwrod(152, 80, 200);
        //����
		final JButton logon_button = bean.button("��½", 100, 150, 100, 50);
		final JButton login_button = bean.button("ע��", 250, 150, 100, 50);
		//�¼�����
		logon_button.addActionListener(
				new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String nameText = name.getText();
						char[] passWord = pass.getPassword();
						String passText = new String(passWord);
						System.out.println("name:"+nameText+" pass:"+passText);
					}
				}
		);
		
		//����
		JFrame jf = logon_frame(name_title,pass_title,name,pass,login_button,logon_button);
		jf.setVisible(true);
		
		
	}
	
    public JFrame logon_frame(Component ... beans){
    	JFrame jf = new JFrame("��½");
    	jf.setBounds(0,0,450,250);
    	jf.setLayout(null);
    	
    	for(int i=0; i<beans.length; i++){
    		jf.add(beans[i]);
    	}
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	return jf;
    }
}
