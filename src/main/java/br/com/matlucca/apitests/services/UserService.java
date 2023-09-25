package br.com.matlucca.apitests.services;

import br.com.matlucca.apitests.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
}
