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
    //����
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
		System.out.println("ע�����");
		return null;
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("���ӳ���");
		return null;
	}
   }
    //��ɾ��
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
			System.out.println("�޸ĳ���");
			return 0;
		}
    	return p;
    }
    //��
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
			System.out.println("���ҳ���");
			return null;
		}
    	return rs;
    }
    //�ر�
    public void allClose(){
    	if(rs!=null){
    		try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();System.out.println("������رճ���");
			}
    	}
    	if(ps!=null){
    		try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();System.out.println("Ԥ����sql�رճ���");
			}
    	}
    	if(c!=null){
    		try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();System.out.println("���ӹرճ���");
			}
    	}
    }
}
