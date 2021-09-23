package com.mock.nativecamp.payload.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor()
public class PatchReq {
    private String name;
    private String email;
    private String password;
    private String birthday;
    private String gender;
    private String credit_token;
    private String profilePic;
    private boolean news;
    private String userNationality;
    private String userResidence;
    private boolean genderNotify;
    private boolean birthdayNotify;
    private boolean userNationalityNotify;
    private boolean userResidenceNotify;
    private String timezone;
}
