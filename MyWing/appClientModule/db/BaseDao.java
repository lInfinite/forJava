package db;

import java.sql.Connection;
import java.sql.ResultSet;

public interface BaseDao {
    public Connection getConnerction();
    public void save_delete_update();
    public ResultSet query();
    public void allClose();
}
