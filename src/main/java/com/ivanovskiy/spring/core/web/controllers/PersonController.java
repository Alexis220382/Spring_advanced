/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanovskiy.spring.core.web.controllers;

import com.ivanovskiy.spring.core.domain.User;
import com.ivanovskiy.spring.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user/person")
public class PersonController { 
   
    @Autowired
    private IUserService personService;

    @RequestMapping(value = {"/add", "/edit"}, method = {RequestMethod.POST})
    public String addPerson(@ModelAttribute("person") User person) {
        personService.save(person);       
        return "redirect:view?id=" + person.getId();
    }

    @ModelAttribute("person")
    public User getPerson(@RequestParam(value = "id", required = false) Long id) {
    User person = null;
        if (id != null) {                           
	    person = personService.getById(id);
        }  
        return person == null ? new User() : person;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewPersonForm() {       
        return "person/view";
    }
   
    @RequestMapping(value = "/edit", method = {RequestMethod.GET})
    public String showEditForm() {       
        return "/person/edit";
    }
}