package aa.service.dao;



import java.util.List;

import aa.entity.Users;


public interface UserServiceDao {
    public void saveUser(Users user);
    public Boolean findUserName(String name);
    public Users createUser(String name,String password);
    public void updateUser(Users u,Users user);
    public void changeUser(Users u,Users user);
    public List<Users> userList(int page);
}
