package com.mock.nativecamp.payload.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor()
public class SignupReq {
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String birthday;
    @NonNull
    private String gender;
    @NonNull
    private String credit_token;
}
