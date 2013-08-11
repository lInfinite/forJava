package base.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Execute {
    Connection c=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    //����
    public Connection OracleConnecton();
    //��ɾ��
    public int change(String sql,Object[] parameter);
    //��
    public ResultSet select(String sql,Object[] parameter);
    //�ر�
    public void allClose();
  }
