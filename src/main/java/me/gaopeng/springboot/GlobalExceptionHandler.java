package me.gaopeng.springboot;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gaopeng on 2017/10/11.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo defaultErrorHandler(HttpServletRequest request, MyException e) throws Exception {
        ErrorInfo info = new ErrorInfo();
        info.setCode(100);
        info.setMessage(e.getMessage());
        info.setUrl(request.getRequestURL().toString());
        return info;
    }
}
