package com.example.commonerror.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class CommonErrorController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    /**
     * 默认错误
     */
    private static final String path_default = "/error";

    @Override
    public String getErrorPath() {
        return path_default;
    }

    /**
     * JSON格式错误信息
     */
    @RequestMapping(value = path_default,  produces = {MediaType.APPLICATION_JSON_VALUE})
    public String error(HttpServletRequest request, WebRequest webRequest) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> body = this.errorAttributes.getErrorAttributes(webRequest, true);
        return body.toString();
    }

}
