package db.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import db.BaseDao;
import db.impl.BaseUtil.sdu;

public class BaseImpl implements BaseDao{
	
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet result = null;

    public Connection getConnerction(){
    	try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection("jdbc:sqlite:MyWing.sqlite3");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	
    }
    
    
    public int update(String sql, Object[] value){
    	connection = this.getConnerction();
    	try {
    		connection.setAutoCommit(false);
    		statement = connection.prepareStatement(sql);
	        for(int i=0; i<value.length-1; i++){
	        	statement.setObject(i+1, value[i]);
	        }
	        int all = statement.executeUpdate();
			connection.commit();
			return all;
		} catch (SQLException e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
			return 0;
		}
    }
    

    public ResultSet query(String sql, Object[] value){
    	connection = this.getConnerction();
    	try {
    		statement = connection.prepareStatement(sql);
			for(int i=0; i<value.length; i++){
				statement.setObject(i+1, value[i]);
			}
			return statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    
    public int update(Object obj, sdu em){
    	BaseUtil util = new BaseUtil();
    	Map<String,Object> map = util.values(obj);
    	List<String> name = util.getValue_name();
    	List<Object> value = util.getValue();
    	String sql = util.sql(util.entityName(obj), name, em);
    	connection = this.getConnerction();	
    	try{
    		connection.setAutoCommit(false);
    		System.out.println(sql);
    		statement = connection.prepareStatement(sql);
    		
    		switch (em) {
			case SAVE:
	    		int i;
	    		for(i=0;i<value.size();i++){
	    		    statement.setObject(i+1, value.get(i));
	    		    System.out.println(value.get(i));
	    		}
				break;
	
			default:
	    		int j;
	    		for(j=0;j<value.size();j++){
	    		    statement.setObject(j+1, value.get(j));
	    		}
	    		statement.setObject(j+2, map.get("id"));
				break;
			}
    		int number = statement.executeUpdate();
    		connection.commit();
    		return number;
    	}catch(SQLException e){
    		try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
    		e.printStackTrace();
    		return 0;
    	}
    }
    
    public void allClose(){
    	try{
	    	if(result!=null){
	    		result.close();
	    	}
	    	
	    	if(statement!=null){
	    		statement.close();
	    	}
	        
	    	if(connection!=null){
	    		connection.close();
	    	}
    	}catch(SQLException e){
	    	e.printStackTrace();
	    }
    }


}
