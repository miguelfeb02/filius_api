package com.dklb.filius.infrastructure.config.interceptor;



import aplication.service.AdminAppService;
import com.dklb.filius.infrastructure.config.singleton.SingletonBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class InterceptorCustom implements HandlerInterceptor {


    @Autowired
    private SingletonBean singletonBean;

    @Autowired
    private AdminAppService adminService;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        return true;
    }


}
