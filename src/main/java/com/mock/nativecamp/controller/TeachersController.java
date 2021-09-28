package com.mock.nativecamp.controller;

import com.mock.nativecamp.payload.teacher.SignupReq;
import com.mock.nativecamp.payload.teacher.PatchReq;
import com.mock.nativecamp.service.TeachersServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/teachers")
public class TeachersController {
    private final TeachersServer teachersServer;

    public TeachersController(TeachersServer teachersServer) {
        this.teachersServer = teachersServer;
    }

    /**
     * Signup teacher
     * @param signupReq
     * @return AdminUser
     * @throws Exception
     */
    @PostMapping(path = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object SignupUser(@RequestBody SignupReq signupReq) throws Exception {
        return teachersServer.signupTeacher(signupReq);
    }

    /**
     * Get all Teachers
     * @return Teachers list
     * @throws Exception
     */
    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object GetAllTeachers() throws Exception {
        return teachersServer.getAllTeachers();
    }

    /**
     * Get one Teacher
     * @return Teachers
     * @throws Exception
     */
    @GetMapping(path = "/teacher", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object GetTeacher(@RequestParam String id) throws Exception {
        return teachersServer.getTeacher(id);
    }


    @PatchMapping(path = "/patch/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object patchTeacher(@PathVariable("userId") String userId, @RequestBody PatchReq patchReq) {
        return teachersServer.updateTeacher(userId, patchReq);
    }
}
