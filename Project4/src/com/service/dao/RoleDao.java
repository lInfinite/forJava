package com.service.dao;

import java.util.List;

import com.entity.Role;

public interface RoleDao {
    public List<Role> query();
    public List<Role> query(int page);
    public List<Role> query(Role role);
    public List<Role> query(Role role, int page);
    public Role role(long id);
}
