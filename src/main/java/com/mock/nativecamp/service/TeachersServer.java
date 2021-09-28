package com.mock.nativecamp.service;

import com.mock.nativecamp.model.Teachers;
import com.mock.nativecamp.payload.teacher.PatchReq;
import com.mock.nativecamp.payload.teacher.SignupReq;
import com.mock.nativecamp.repository.TeachersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TeachersServer {

    @Autowired
    private TeachersRepository teachersRepository;

    public Object signupTeacher(SignupReq signupReq) {
        Teachers teachers = new Teachers().addTeachers(signupReq);
        teachersRepository.save(teachers);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public Object getAllTeachers() {
        return teachersRepository.findAll();
    }

    public Object getTeacher(String id) {
        return teachersRepository.findByUserId(id);
    }

    public Object updateTeacher(String userId, PatchReq patchReq) {
        Teachers teacher = teachersRepository.findByUserId(userId);
        if (teacher == null) {
            log.error(String.format("Teacher not found id: %s", userId));
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        teacher.updateTeacher(teacher, patchReq);
        teachersRepository.save(teacher);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
