package com.service.dao;

import java.util.List;

import com.entity.CreateClinet;


public interface CreateClinetDao {

	public List<CreateClinet> query();
    public List<CreateClinet> query(int page);
    public List<CreateClinet> query(CreateClinet create_clinet);
    public List<CreateClinet> query(CreateClinet create_clinet, int page);
    public CreateClinet createClinet(long id);
}
