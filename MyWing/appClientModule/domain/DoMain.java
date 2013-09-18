package domain;


import java.util.List;

import db.impl.BaseImpl;
import db.impl.BaseUtil;
import db.impl.BaseUtil.sdu;
import entity.User;
import frame.Logon;

public class DoMain {
    
    public static void main(String[] args){
    	//new Logon();
    	BaseImpl base = new BaseImpl();
    	
    	User u = new User();
    	u.setId(1);
    	u.setName("a");
    	u.setPassword("22");
    	
    	base.update(u, sdu.SAVE);
    }
    
   
}
