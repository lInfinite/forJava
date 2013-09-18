package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public interface BaseDao {
    public Connection getConnerction();
    public void update(String sql, Object[] value);
    public ResultSet query(String sql, Object[] value);
    public void allClose();
}
