package com.carlfiller.icourtwatch;

import com.carlfiller.icourtwatch.controllers.AbstractController;
import com.carlfiller.icourtwatch.models.User;
import com.carlfiller.icourtwatch.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        List<String> nonAuthPages = Arrays.asList("/user/index", "/user/signup");

        if ( !nonAuthPages.contains(request.getRequestURI())) {

            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
                User user =userDao.findOne(userId);

                if (user != null) {
                    return true;
                }
            }


            response.sendRedirect("/index");
            return false;
        }

        return true;
    }

}
