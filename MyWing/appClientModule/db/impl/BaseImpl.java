package db.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.BaseDao;

public class BaseImpl implements BaseDao{

    public Connection getConnerction(){
    	try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection("jdbc:sqlite:");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	
    }
    
    
    public void save_delete_update(){
    	
    }
    

    public ResultSet query(){
    	return null;
    }
    public void allClose(){
    	
    }
}
