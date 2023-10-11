package br.com.matlucca.apitests.services;

import br.com.matlucca.apitests.domain.User;
import br.com.matlucca.apitests.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();

    User create(UserDTO obj);
    User update(UserDTO obj);

    void delete(Integer id);
}
