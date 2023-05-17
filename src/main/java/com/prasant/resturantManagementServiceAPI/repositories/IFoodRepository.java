package com.prasant.resturantManagementServiceAPI.repositories;

import com.prasant.resturantManagementServiceAPI.models.Food;
import org.springframework.data.repository.ListCrudRepository;

public interface IFoodRepository extends ListCrudRepository<Food, Long> {
}
