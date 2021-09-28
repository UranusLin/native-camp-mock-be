package com.mock.nativecamp.payload.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor()
public class PatchReq {
    @NonNull
    private String firstName;
    private String middleName;
    @NonNull
    private String lastName;
    @NonNull
    private String birthday;
    private String referrerEmail;
    @NonNull
    private String country;
    @NonNull
    private String nationality;
}
