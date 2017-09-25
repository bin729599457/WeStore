package com.westore.interceptor;

import com.westore.model.AjaxJSON;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor{

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String trd_session = httpServletRequest.getParameter("trd_session");
        if(trd_session == null){
            AjaxJSON ajs = new AjaxJSON();
            ajs.setSuccess(false);
            ajs.setMsg("no Login");
            PrintWriter out = httpServletResponse.getWriter();
            out.print(JSONObject.fromObject(ajs));
            return false;
        }
        else {
            return true;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
