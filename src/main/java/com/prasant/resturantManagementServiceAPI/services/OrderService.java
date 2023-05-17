package com.prasant.resturantManagementServiceAPI.services;

import com.prasant.resturantManagementServiceAPI.models.Admin;
import com.prasant.resturantManagementServiceAPI.models.Food;
import com.prasant.resturantManagementServiceAPI.models.Order;
import com.prasant.resturantManagementServiceAPI.models.User;
import com.prasant.resturantManagementServiceAPI.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private FoodService foodService;

    public String addOrder(Long foodId, Integer quantity, String token) {
        Admin admin = adminService.getAdminByToken(token);
        User user = userService.getUserByToken(token);

        if (admin != null){
            boolean isFoodPresent = foodService.isExist(foodId);
            if (!isFoodPresent){
                return  "Food doesn't exist!";
            }

            Order order = new Order(quantity, new Food(foodId), admin);
            orderRepository.save(order);
            return "Order placed! Status : " + order.getStatus();
        }

        if (user != null){
            boolean isFoodPresent = foodService.isExist(foodId);
            if (!isFoodPresent){
                return  "Food doesn't exist!";
            }

            Order order = new Order(quantity, new Food(foodId), user);
            orderRepository.save(order);
            return "Order placed! Status : " + order.getStatus();
        }

        return "Invalid token!";
    }
}
