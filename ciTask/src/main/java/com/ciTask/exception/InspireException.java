package com.ciTask.exception;

import com.ciTask.dictionary.APIErrorCode;

public class InspireException extends RuntimeException {
    private APIErrorCode errorCode;
    private String errorMessage;

    public InspireException(APIErrorCode errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public InspireException(APIErrorCode errorCode) {
        this.errorCode = errorCode;
    }
    public APIErrorCode getErrorCode() {
        return errorCode;
    }

}
