package com.mock.nativecamp.model;

import com.mock.nativecamp.payload.user.SignupReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String status;
    private String coin;
    private String timezone;
    private String payMethod;
    private String nextPayCheck;
    private String ssoId;
    private String gender;
    private String creditToken;
    private String profilePic;
    private boolean news;
    private String birthday;
    private String userNationality;
    private String userResidence;
    private boolean genderNotify;
    private boolean birthdayNotify;
    private boolean userNationalityNotify;
    private boolean userResidenceNotify;

    public Users signUser(SignupReq signupReq) {
        Users user = new Users();
        user.setName(signupReq.getName());
        user.setEmail(signupReq.getEmail());
        user.setPassword(signupReq.getPassword());
        user.setBirthday(signupReq.getBirthday());
        user.setGender(signupReq.getGender());
        user.setCreditToken(signupReq.getCredit_token());
        return user;
    }
}
