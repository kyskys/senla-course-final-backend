package com.senla.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";
	private static Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);
			
	@ResponseStatus(reason="No entities found for this request", code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoResultException.class)
	public void handleNoResultException() {
		
	}

	
	@ExceptionHandler(value = Exception.class)
	  public ModelAndView
	  defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	    // If the exception is annotated with @ResponseStatus rethrow it and let
	    // the framework handle it - like the OrderNotFoundException example
	    // at the start of this post.
	    // AnnotationUtils is a Spring Framework utility class.
		logger.error(e);
	    if (AnnotationUtils.findAnnotation
	                (e.getClass(), ResponseStatus.class) != null)
	      throw e;

	    // Otherwise setup and send the user to a default error-view.
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("url", req.getRequestURL());
	    return mav;
	  }
}
