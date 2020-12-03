package com.neusoft.dao;

import com.neusoft.domain.food;

import java.util.List;

public interface FoodDao {
    public List<food> listFoodByBusinessId(Integer businesId);
    public int saveFood(food food);
    public int updateFood(food food);
    public int removeFood(Integer foodId);
    public food getFoodById(Integer foodId);
}
