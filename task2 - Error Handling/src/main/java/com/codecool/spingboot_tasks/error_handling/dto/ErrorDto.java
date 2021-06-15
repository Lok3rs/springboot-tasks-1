package com.codecool.spingboot_tasks.error_handling.dto;

public class ErrorDto {
    private String msg;
    private ErrorLevel level = ErrorLevel.WARN;
    private String moreDetails;

    public ErrorDto(String msg, String moreDetails) {
        this.msg = msg;
        this.moreDetails = moreDetails;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(String moreDetails) {
        this.moreDetails = moreDetails;
    }

    public ErrorLevel getLevel() {
        return level;
    }

    public void setLevel(ErrorLevel level) {
        this.level = level;
    }
}
