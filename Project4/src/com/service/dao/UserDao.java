package com.service.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	public User user(User user, boolean password);
    public User user(long id);
}
