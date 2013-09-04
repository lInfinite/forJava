package com.service.dao;

import java.util.List;
import java.util.Set;

import com.entity.SellChance;

public interface SellDao {
    public SellChance sellChance(long id);
    public List list_for_OneToMany(Set one_to_many);
}
