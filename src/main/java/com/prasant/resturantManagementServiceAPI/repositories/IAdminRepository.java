package com.prasant.resturantManagementServiceAPI.repositories;

import com.prasant.resturantManagementServiceAPI.models.Admin;
import org.springframework.data.repository.ListCrudRepository;

public interface IAdminRepository extends ListCrudRepository<Admin, Long> {
    boolean existsByEmail(String email);
}
