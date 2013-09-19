package domain;


import java.sql.ResultSet;
import java.sql.SQLException;
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
    	String sql = "select * from user";
    	Object[] value ={};
    	ResultSet rs = base.query(sql, value);
    	try {
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				System.out.println("id:"+id+" name:"+name+" password:"+password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	new Logon();
    }
    
   
}
