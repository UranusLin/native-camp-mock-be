package com.mock.nativecamp.service;

import com.mock.nativecamp.model.Users;
import com.mock.nativecamp.payload.CommonResponse;
import com.mock.nativecamp.payload.sub.ResData;
import com.mock.nativecamp.payload.user.PatchReq;
import com.mock.nativecamp.payload.user.SignupReq;
import com.mock.nativecamp.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public CommonResponse signupUser(SignupReq signupReq) {
        Users user = new Users().signUser(signupReq);
        usersRepository.save(user);
        CommonResponse commonResponse = new CommonResponse().successRes();
        ResData resData = new ResData();
        resData.setData(user);
        commonResponse.setData(resData);
        return commonResponse;
    }

    public CommonResponse getAllUsers() {
        List<Users> users = usersRepository.findAll();
        CommonResponse commonResponse = new CommonResponse().successRes();
        ResData resData = new ResData();
        resData.setData(users);
        commonResponse.setData(resData);
        return commonResponse;
    }

    public CommonResponse getUser(String id) {
        Users user = usersRepository.findByUserId(id);
        CommonResponse commonResponse = new CommonResponse().successRes();
        if (user == null) {
            commonResponse = commonResponse.errorRes("user id not found", "404");
        }
        ResData resData = new ResData();
        resData.setData(user);
        commonResponse.setData(resData);
        return commonResponse;
    }

    public CommonResponse updateUser(String userId, PatchReq patchReq) {
        Users user = usersRepository.findByUserId(userId);
        CommonResponse commonResponse = new CommonResponse().successRes();
        if (user == null) {
            commonResponse = new CommonResponse().errorRes("user id not found", "404");
        } else {
            user.updateUser(user, patchReq);
            usersRepository.save(user);
        }
        ResData resData = new ResData();
        resData.setData(user);
        commonResponse.setData(resData);
        return commonResponse;
    }
}
