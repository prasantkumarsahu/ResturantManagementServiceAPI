package com.prasant.resturantManagementServiceAPI.repositories;

import com.prasant.resturantManagementServiceAPI.models.AdminAuthenticationToken;
import org.springframework.data.repository.ListCrudRepository;

public interface IAdminAuthenticationTokenRepository extends ListCrudRepository<AdminAuthenticationToken, Long> {
    AdminAuthenticationToken findByToken(String token);

    boolean existsByToken(String token);
}
