package base.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteSql implements Execute{
    Connection c=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    //连接
    public Connection OracleConnecton(){
		String DIRVER="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@aptech.keji.asia:1521:orcl";
		String user="pb_linw";
		String password="LinWei88135";
	   try {
		Class.forName(DIRVER);
		c=DriverManager.getConnection(url, user, password);
        return c;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.out.println("注册出错");
		return null;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("连接出错");
		return null;
	}
   }
    //增删改
    public int change(String sql,Object[] parameter){
    	int p=0;
    	OracleConnecton();
    	try {
			ps=c.prepareStatement(sql);
			for(int i=0;i<parameter.length;i++){
				ps.setObject(i+1, parameter[i]);
			}
			p=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("修改出错");
			return 0;
		}
    	return p;
    }
    //查
    public ResultSet select(String sql,Object[] parameter){
    	OracleConnecton();
    	try {
			ps=c.prepareStatement(sql);
			for(int i=0;i<parameter.length;i++){
				ps.setObject(i+1, parameter[i]);
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查找出错");
			return null;
		}
    	return rs;
    }
    //关闭
    public void allClose(){
    	if(rs!=null){
    		try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();System.out.println("结果集关闭出错");
			}
    	}
    	if(ps!=null){
    		try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();System.out.println("预编译sql关闭出错");
			}
    	}
    	if(c!=null){
    		try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();System.out.println("连接关闭出错");
			}
    	}
    }
}
