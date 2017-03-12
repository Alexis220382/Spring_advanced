package com.epam.spring.core.web.exception;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.epam.spring.core.web.controllers")
public class ExceptionControllerAdvice {


	public static final String DEFAULT_ERROR_VIEW = "error_view";

	@ExceptionHandler(value = Throwable.class)
	public ModelAndView expHandler(Throwable e) {
		ModelAndView errorView = new ModelAndView(DEFAULT_ERROR_VIEW);
		errorView.addObject("message",  e.getMessage());
		errorView.addObject("stackTrace", ExceptionUtils.getStackTrace(e));
		e.printStackTrace();
		return errorView;
	}

}
