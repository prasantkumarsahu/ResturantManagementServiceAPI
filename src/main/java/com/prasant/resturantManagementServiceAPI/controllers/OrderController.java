package com.prasant.resturantManagementServiceAPI.controllers;

import com.prasant.resturantManagementServiceAPI.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("{foodId}/{quantity}/{token}")
    public String addOrder(@PathVariable Long foodId, @PathVariable Integer quantity, @PathVariable String token){
        return orderService.addOrder(foodId, quantity, token);
    }

}
