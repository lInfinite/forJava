package domain;


import java.util.List;
import java.util.Map;

import db.impl.BaseImpl;
import db.impl.BaseUtil;
import db.impl.BaseUtil.sdu;
import entity.User;
import frame.Logon;

public class DoMain {
    
    public static void main(String[] args){
    	//new Logon();
    	User user = new User();
    	BaseUtil util = new BaseUtil();
    	util.setterValue(user, "name", "hahaha");
    	util.setterValue(user, "id", 1);
    	System.out.println(user.getName());
    	System.out.println(user.getId());
    	
    }
    
   
}
