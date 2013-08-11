package aa.service.dao;

import java.util.List;

import aa.entity.Days;
import aa.entity.Users;

public interface DaysSericeDao {
    public Days createDays(int id);
	public List<Users> selectUsers();
    public List<Days> selectAllDays(int page);
    public List<Days> selectIdDays(int read_id,int page);
    public void saveDays(Days days);
    public void updateDays(Days days);
}
