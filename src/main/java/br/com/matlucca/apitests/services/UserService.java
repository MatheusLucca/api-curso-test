package br.com.matlucca.apitests.services;

import br.com.matlucca.apitests.domain.User;
import br.com.matlucca.apitests.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();

    User create(UserDto obj);
}
