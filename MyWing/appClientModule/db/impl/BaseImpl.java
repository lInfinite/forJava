package db.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    
    public void update(String sql, Object[] value){
    	connection = this.getConnerction();
    	try {
    		connection.setAutoCommit(false);
    		statement = connection.prepareStatement(sql);
	        for(int i=0; i<value.length-1; i++){
	        	statement.setObject(i+1, value[i]);
	        }
	        statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
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
    
    
    public void update(Object obj, sdu em){
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
    		statement.executeUpdate();
    		connection.commit();
    	}catch(SQLException e){
    		try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
    		e.printStackTrace();
    	}
    }
    
    
    public List list(String sql, Object[] value,Object obj){
    	List list = new ArrayList();
    	BaseUtil util = new BaseUtil();
    	connection = this.getConnerction();
    	List<String> obj_name = util.entityNames(obj);
    	try {
			statement = connection.prepareStatement(sql);
			for(int i=0; i<value.length; i++){
				statement.setObject(i+1, value[i]);
			}
			result = statement.executeQuery();
			int num = 0;
			while(result.next()){
				/**
				 * 因为Object是引用类型，传过来的只是内存地址，
				 * 修改同一个object只是修改了同一内存地址的内容。
				 * 因此要获取object传递过来的字节码并实例化一个初始的对象，
				 * 使每次循环都在内存创建新的空间地址确保每次循环添加到list的都是不同的‘对象’。
				 */
				Object o = obj.getClass().newInstance();
				for(int i=0; i<obj_name.size(); i++){
					String name = obj_name.get(i);
					util.setterValue(o, name, result.getObject(name));
				}
				list.add(o);
			}
		return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
