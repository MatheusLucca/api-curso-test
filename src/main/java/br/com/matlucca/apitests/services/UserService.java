package br.com.matlucca.apitests.services;

import br.com.matlucca.apitests.domain.User;

public interface UserService {

    User findById(Integer id);
}
