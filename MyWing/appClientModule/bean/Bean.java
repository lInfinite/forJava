package bean;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Bean {
    
    
    public JButton button(String title, int x, int y, int width, int height){
    	JButton button = new JButton(title);
    	button.setBounds(x, y, width, height);
    	return button;
    }
    
    
    public JTextField text(int x, int y, int width){
    	JTextField text = new JTextField();
    	text.setBounds(x, y, width, 35);
    	return text;
    }
    
    
    public JLabel title(String title, int x, int y, int width, int height){
    	JLabel jl = new JLabel(title);
    	jl.setBounds(x, y, width, height);
    	return jl;
    }
    
    
    public JPasswordField passwrod(int x, int y, int width){
    	JPasswordField password = new JPasswordField();
    	password.setBounds(x, y, width, 35);
    	return password;
    }
    
    public JFrame frame(String title,int x, int y, int width, int height, Component ... beans){
    	JFrame jf = new JFrame(title);
    	jf.setBounds(x, y, width, height);
    	jf.setLayout(null);
    	
    	for(int i=0; i<beans.length; i++){
    		jf.add(beans[i]);
    	}
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	return jf;
    }
}
