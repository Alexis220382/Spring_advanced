package com.epam.spring.core.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.service.IEventService;
import com.epam.spring.core.service.IUserService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/upload/files")
public class FileUploadController {

	private final static String UPLOAD_USERS = "upload/upload_users";
	private final static String UPLOAD_EVENTS = "upload/upload_events";
	private final static String SUCCESS_UPLOAD = "upload/success";
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IEventService eventService;

	@RequestMapping(value = "/users")
	public String loadUploadUsersForm() {
		return UPLOAD_USERS;
	}

	@RequestMapping(value = "/events")
    public String loadUploadEventsForm() {
		return UPLOAD_EVENTS;
	}

	@RequestMapping(value = "/users_upload")
	public String handleFileUsersUpload(
            Model model,
			@RequestParam(required = false) CommonsMultipartFile fileUsers)
	{
		Gson gson = new Gson();

		User[] users = gson.fromJson(new String(fileUsers.getBytes()), User[].class);
		if (users != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            for (User user : users) {
                User u = userService.getUserByUsername(user.getUsername());
                String password = user.getPassword();
                user.setPassword(passwordEncoder.encode(password));
                if (u != null) {
                    user.setPassword(u.getPassword());
                    user.setUsername(u.getUsername());
                    user.setEnabled(u.isEnabled());
                    user.setId(u.getId());
                }
                userService.save(user);
            }
        } else {
            model.addAttribute("users_error", "Warning! Users file not uploaded or contains not valid data.");
        }
        model.addAttribute("user_flag", true);
        return SUCCESS_UPLOAD;
	}

	@RequestMapping(value = "/events_upload")
    public String handleFileEventUpload(
            Model model,
            @RequestParam(required = false) CommonsMultipartFile fileEvents)
    {
        Gson gson = new Gson();

        Event[] events = gson.fromJson(new String(fileEvents.getBytes()), Event[].class);
        if (events != null) {
            for (Event event : events) {
                eventService.save(event);
            }
        } else {
            model.addAttribute("events_error", "Warning! Events file not uploaded or contains not valid data.");
        }
        model.addAttribute("event_flag", true);
        return SUCCESS_UPLOAD;
    }
	
}
