package com.neusoft.view;

import com.neusoft.domain.food;

import java.util.List;

public interface FoodView {
    public List<food> showFoodList(Integer businessId);
    public void saveFood(Integer businessId);
    public void updateFood(Integer businessId);
    public void removeFood(Integer foodId);
}
