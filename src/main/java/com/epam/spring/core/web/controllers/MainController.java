package com.epam.spring.core.web.controllers;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.web.util.Util;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey-Ivanovskiy on 27.02.2017.
 */
@Controller
public class MainController {

    private static final String LOGIN_PAGE = "login";
    private static final String HOME_PAGE = "index";
    private static final String ACCESS_DENIED_PAGE = "access_denied";

    @RequestMapping(value = "/")
    public ModelAndView homePage(HttpServletRequest request,
                           @RequestParam(required = false) String error) throws JAXBException, IOException {
        ModelAndView model = new ModelAndView(LOGIN_PAGE);
        if (error != null) {
            model.addObject("error", "Invalid username and password!");

            //login form for update page
            //if login error, get the targetUrl from session again.
            String targetUrl = getRememberMeTargetUrlFromSession(request);
            if(StringUtils.hasText(targetUrl)){
                model.addObject("targetUrl", targetUrl);
                model.addObject("loginUpdate", true);
            }

        }

        JAXBContext jaxbContext1 = JAXBContext.newInstance( User.class );
        jaxbContext1.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                File file = new File(suggestedFileName);
                StreamResult result = new StreamResult(file);
                result.setSystemId(file.toURI().toURL().toString());
                return result;
            }
        });

        model.addObject("error", error);
        return model;
    }

    @RequestMapping(value = "/user/home")
    public ModelAndView start(HttpServletRequest request) {

        ModelAndView model = new ModelAndView();

        if (isRememberMeAuthenticated()) {
            //send login for update
            setRememberMeTargetUrlToSession(request);
            model.addObject("loginUpdate", true);
            model.setViewName(LOGIN_PAGE);

        } else {
            model.addObject("user", Util.getPrincipal());
            model.setViewName(HOME_PAGE);
        }
        return model;
    }

    @RequestMapping(value="/logout")
    public void logoutPage (HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        response.sendRedirect("/");
    }

    @RequestMapping(value = "/Access_Denied")
    public String accessDeniedPage(ModelMap model) {

        model.addAttribute("user", Util.getPrincipal());
        return ACCESS_DENIED_PAGE;
    }

    private boolean isRememberMeAuthenticated() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }

        return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
    }

    private void setRememberMeTargetUrlToSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.setAttribute("targetUrl", "/admin/update");
        }
    }

    private String getRememberMeTargetUrlFromSession(HttpServletRequest request){
        String targetUrl = "";
        HttpSession session = request.getSession(false);
        if(session!=null){
            targetUrl = session.getAttribute("targetUrl")==null?""
                    :session.getAttribute("targetUrl").toString();
        }
        return targetUrl;
    }
}
