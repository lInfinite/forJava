package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.impl.BaseUtil.sdu;


public interface BaseDao {
    public Connection getConnerction();
    public int update(String sql, Object[] value);
    public ResultSet query(String sql, Object[] value);
    public int update(Object obj, sdu em);
    public void allClose();
}
