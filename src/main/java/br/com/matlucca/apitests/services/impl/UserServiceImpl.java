package br.com.matlucca.apitests.services.impl;

import br.com.matlucca.apitests.domain.User;
import br.com.matlucca.apitests.domain.dto.UserDto;
import br.com.matlucca.apitests.repositories.UserRepository;
import br.com.matlucca.apitests.services.UserService;
import br.com.matlucca.apitests.services.exceptions.DataIntegratyViolationException;
import br.com.matlucca.apitests.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserRepository repository;
    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    @Override
    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDto obj){
        findByEmail(obj);
        return repository.save(mapper.map(obj,User.class));
    }

    private void findByEmail(UserDto obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent()){
            throw new DataIntegratyViolationException("Email ja cadastrado no sistema");
        }
    }

}
