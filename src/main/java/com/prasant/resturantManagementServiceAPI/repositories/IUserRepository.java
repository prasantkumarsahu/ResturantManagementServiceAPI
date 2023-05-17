package com.prasant.resturantManagementServiceAPI.repositories;

import com.prasant.resturantManagementServiceAPI.models.User;
import org.springframework.data.repository.ListCrudRepository;

public interface IUserRepository extends ListCrudRepository<User, Long> {
    boolean existsByEmail(String email);

    User findByEmail(String email);
}
