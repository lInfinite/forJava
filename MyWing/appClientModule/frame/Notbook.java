package frame;


import javax.swing.JFrame;
import javax.swing.JTextArea;

import bean.Bean;

public class Notbook {

	Bean bean = new Bean();
	
	
	public Notbook(){
    	JTextArea jta = new JTextArea(250, 200);
    	jta.setLineWrap(true);
    	jta.setBounds(0, 0, 500, 400);
    	JFrame notbook = bean.frame("±Ê¼Ç±¾", 200, 200, 500, 400, jta);
    	notbook.setVisible(true);
    }
}
