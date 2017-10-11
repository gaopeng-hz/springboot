package me.gaopeng.springboot;

/**
 * Created by gaopeng on 2017/10/11.
 */
public class ErrorInfo<T> {

    private Integer code;
    private String message;
    private String url;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
