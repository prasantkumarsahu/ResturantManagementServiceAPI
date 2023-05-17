package com.prasant.resturantManagementServiceAPI.controllers;

import com.prasant.resturantManagementServiceAPI.models.Food;
import com.prasant.resturantManagementServiceAPI.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("visitor")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping()
    public List<Food> getAllFoods(){
        return visitorService.getAllFoods();
    }
}
