package com.prasant.resturantManagementServiceAPI.services;

import com.prasant.resturantManagementServiceAPI.dtos.FoodInput;
import com.prasant.resturantManagementServiceAPI.models.Food;
import com.prasant.resturantManagementServiceAPI.repositories.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private IFoodRepository foodRepository;

    @Autowired
    private AdminService adminService;

    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    public void saveFood(FoodInput foodInput) {

    }

    public String addFood(String token, FoodInput foodInput) {
        boolean isAuthenticate = adminService.authenticateToken(token);
        if (!isAuthenticate){
            return "Invalid admin!";
        }

        Food food = new Food(foodInput.getTitle(), foodInput.getDescription(), foodInput.getPrice(), foodInput.getDummyImage());
        foodRepository.save(food);
        return "Food is saved!";
    }

    public String deleteFood(String token, Long id) {
        boolean isAuthenticate = adminService.authenticateToken(token);
        if (!isAuthenticate){
            return "Invalid admin!";
        }

        boolean isPresent = foodRepository.existsById(id);
        if (!isPresent){
            return "Food doesn't exist!";
        }

        foodRepository.deleteById(id);
        return "Food is saved!";
    }

    public boolean isExist(Long foodId) {
        return foodRepository.existsById(foodId);
    }
}
