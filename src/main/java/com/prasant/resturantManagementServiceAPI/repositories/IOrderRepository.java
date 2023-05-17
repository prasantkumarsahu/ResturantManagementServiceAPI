package com.prasant.resturantManagementServiceAPI.repositories;

import com.prasant.resturantManagementServiceAPI.models.Order;
import org.springframework.data.repository.ListCrudRepository;

public interface IOrderRepository extends ListCrudRepository<Order, Long> {
}
