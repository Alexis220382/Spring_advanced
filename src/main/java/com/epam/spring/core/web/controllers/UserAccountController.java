package com.epam.spring.core.web.controllers;

import com.epam.spring.core.domain.User;
import com.epam.spring.core.domain.UserAccount;
import com.epam.spring.core.service.IUserAccountService;
import com.epam.spring.core.service.IUserService;
import com.epam.spring.core.web.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Alexey-Ivanovskiy on 12.03.2017.
 */
@Controller
@RequestMapping("/userAccount")
public class UserAccountController {

    private static final String HOME_PAGE = "index";

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserAccountService userAccountService;

    @RequestMapping(method = RequestMethod.GET)
    public String setUserAccount(@RequestParam String account,
                                 Model model){
        User user = userService.getUserByUsername(Util.getPrincipal());
        UserAccount userAccount = new UserAccount();
        userAccount.setAccount(Double.parseDouble(account));
        userAccount.setUser(user);
        userAccountService.save(userAccount);
        model.addAttribute("user", Util.getPrincipal());
        return HOME_PAGE;
    }


}
