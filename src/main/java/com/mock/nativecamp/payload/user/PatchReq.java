package com.mock.nativecamp.payload.user;

import lombok.Data;

@Data
public class PatchReq {
    private String name;
    private String birthday;
    private String gender;
    private String credit_token;
    private String profilePic;
    private Boolean news;
    private String userNationality;
    private String userResidence;
    private Boolean genderNotify;
    private Boolean birthdayNotify;
    private Boolean userNationalityNotify;
    private Boolean userResidenceNotify;
    private String timezone;
}
