package com.mock.nativecamp.handler;

import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.mock.nativecamp.exception.ClientHttpServerErrorException;
import com.mock.nativecamp.exception.TransactionNotFoundException;
import com.mock.nativecamp.payload.CommonResponse;
import com.mock.nativecamp.payload.sub.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    /**
     * Inquiry not found
     *
     * @param e
     * @return paymentMSErrorResponse
     */
    @ExceptionHandler(TransactionNotFoundException.class)
    @ResponseBody
    public Object handleNotFound(TransactionNotFoundException e) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setInfo(generateInfo("404", e.getMessage()));
        log.error("catch Not Found error: " + commonResponse.toString());
        return commonResponse;
    }

    /**
     * @param e
     * @return Object
     */
    @ExceptionHandler(ClientHttpServerErrorException.class)
    @ResponseBody
    public Object handleClientError(ClientHttpServerErrorException e) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setInfo(generateInfo(e.getMessage().split("\\s+")[0], e.getMessage()));
        log.error("catch  error: " + commonResponse.toString());
        return commonResponse;
    }

    @ExceptionHandler(ValueInstantiationException.class)
    @ResponseBody
    public Object handleValidError(ValueInstantiationException e) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setInfo(generateInfo("401", e.getOriginalMessage().split("problem: ")[1]));
        return commonResponse;
    }

    private Info generateInfo(String code, String message) {
        Info info = new Info();
        info.setStatus(code);
        info.setMessage(message);
        return info;
    }
}
