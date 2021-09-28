package com.mock.nativecamp.service;

import com.mock.nativecamp.model.Users;
import com.mock.nativecamp.payload.user.PatchReq;
import com.mock.nativecamp.payload.user.SignupReq;
import com.mock.nativecamp.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Object signupUser(SignupReq signupReq) {
        Users user = new Users().signUser(signupReq);
        usersRepository.save(user);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public Object getAllUsers() {
        return usersRepository.findAll();
    }

    public Object getUser(String id) {
        return usersRepository.findByUserId(id);
    }

    public Object updateUser(String userId, PatchReq patchReq) {
        Users user = usersRepository.findByUserId(userId);
        user.updateUser(user, patchReq);
        usersRepository.save(user);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
