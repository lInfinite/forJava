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
    //连接
    public Connection OracleConnecton();
    //增删改
    public int change(String sql,Object[] parameter);
    //查
    public ResultSet select(String sql,Object[] parameter);
    //关闭
    public void allClose();
  }
