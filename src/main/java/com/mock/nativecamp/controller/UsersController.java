package com.mock.nativecamp.controller;

import com.mock.nativecamp.payload.user.PatchReq;
import com.mock.nativecamp.payload.user.SignupReq;
import com.mock.nativecamp.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    /**
     * Signup user
     * @param signupReq
     * @return AdminUser
     * @throws Exception
     */
    @PostMapping(path = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object SignupUser(@RequestBody SignupReq signupReq) throws Exception {
        return usersService.signupUser(signupReq);
    }

    /**
     * Get all Users
     * @return Users list
     * @throws Exception
     */
    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object GetAllUsers() throws Exception {
        return usersService.getAllUsers();
    }

    /**
     * Get one user
     * @return Users
     * @throws Exception
     */
    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object GetUsers(@RequestParam String id) throws Exception {
        return usersService.getUser(id);
    }

    @PatchMapping(path = "/patch/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object patchUser(@PathVariable("userId") String userId, @RequestBody PatchReq patchReq) {
        return usersService.updateUser(userId, patchReq);
    }

}
