package service.dao;

import entity.User;

public interface UserServiceDao {
    public boolean hasUserName(User u);
    public boolean hasUser(User u);
}
