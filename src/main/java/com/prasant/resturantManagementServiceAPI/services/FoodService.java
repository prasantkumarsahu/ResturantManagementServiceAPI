package com.prasant.resturantManagementServiceAPI.services;

import com.prasant.resturantManagementServiceAPI.models.Food;
import com.prasant.resturantManagementServiceAPI.repositories.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private IFoodRepository foodRepository;

    public List<Food> getFoods() {
        return foodRepository.findAll();
    }
}
