package com.mock.nativecamp.payload;

import com.mock.nativecamp.payload.sub.Info;
import com.mock.nativecamp.payload.sub.ResData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor()
@NoArgsConstructor
public class CommonResponse {
    private Info info;
    private ResData data;

    public CommonResponse successRes() {
        CommonResponse commonResponse = new CommonResponse();
        Info info = new Info();
        info.setCode("0000");
        info.setMessage("success");
        commonResponse.setInfo(info);
        return commonResponse;
    }

    public  CommonResponse errorRes(String msg, String code) {
        CommonResponse commonResponse = new CommonResponse();
        Info info = new Info();
        info.setCode(code);
        info.setMessage(msg);
        commonResponse.setInfo(info);
        return commonResponse;
    }
}
