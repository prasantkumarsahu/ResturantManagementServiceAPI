package com.prasant.resturantManagementServiceAPI.repositories;

import com.prasant.resturantManagementServiceAPI.models.UserAuthenticationToken;
import org.springframework.data.repository.ListCrudRepository;

public interface IUserAuthenticationTokenRepository extends ListCrudRepository<UserAuthenticationToken, Long> {
    UserAuthenticationToken findByToken(String token);
}
