package com.service.dao;

import java.util.List;
import java.util.Set;

import com.entity.CreateClinet;
import com.entity.SellChance;

public interface SellDao {
    public SellChance sellChance(long id);
    public CreateClinet createClient(long id);
}
