package br.com.matlucca.apitests.controllers;

import br.com.matlucca.apitests.domain.User;
import br.com.matlucca.apitests.domain.dto.UserDto;
import br.com.matlucca.apitests.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDto.class));
    }
}
