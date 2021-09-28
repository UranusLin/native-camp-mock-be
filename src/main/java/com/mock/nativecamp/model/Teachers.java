package com.mock.nativecamp.model;

import com.mock.nativecamp.payload.teacher.PatchReq;
import com.mock.nativecamp.payload.teacher.SignupReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Teachers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teachers {
    @Id
    private String userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String status;
    private String timezone;
    private String birthday;
    private String country;
    private String nationality;
    private String referrerEmail;
    private String classStatus;
    private String introductionVideo;
    private String rating;
    private String lastLogin;
    private Integer classCount;
    private Integer reservationCount;
    private Integer reservationCancelCount;
    private String selfIntroduction;
    private String employeeIntroduction;
    private String teachingYears;
    private List<String> picList;
    private List<String> badge;
    private List<String> characteristic;
    private List<String> hobby;

    public Teachers addTeachers(SignupReq signupReq) {
        Teachers teachers = new Teachers();
        teachers.setFirstName(signupReq.getFirstName());
        teachers.setMiddleName(signupReq.getMiddleName());
        teachers.setLastName(signupReq.getLastName());
        teachers.setEmail(signupReq.getEmail());
        teachers.setPassword(signupReq.getPassword());
        teachers.setBirthday(signupReq.getBirthday());
        teachers.setReferrerEmail(signupReq.getReferrerEmail());
        teachers.setCountry(signupReq.getCountry());
        teachers.setNationality(signupReq.getNationality());
        return teachers;
    }

    public Teachers updateTeacher(Teachers teacher, PatchReq patchReq) {
        teacher.setFirstName(patchReq.getFirstName());
        if (patchReq.getMiddleName() != null) {
            teacher.setMiddleName(patchReq.getMiddleName());
        }
        teacher.setLastName(patchReq.getLastName());
        teacher.setBirthday(patchReq.getBirthday());
        if (teacher.getReferrerEmail() == null & patchReq.getReferrerEmail() != null) {
            teacher.setReferrerEmail(patchReq.getReferrerEmail());
        }
        teacher.setCountry(patchReq.getCountry());
        teacher.setNationality(patchReq.getNationality());
        return teacher;
    }
}
