package com.senla.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.RequestContextFilter;

import com.senla.entity.User;
import com.senla.holder.provider.ApplicationContextProvider;
import com.senla.holder.user.CurrentUserHolder;
import com.senla.web.util.JWTManager;

public class JWTFilter extends RequestContextFilter {

	private static final int STATUS_CODE_UNAUTHORISED = 401;
	private static final String REQUEST_AUTH_HEADER = "Auth";

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String token = request.getHeader(REQUEST_AUTH_HEADER);
		if (JWTManager.verifyToken(token)) {
			User user = JWTManager.getCurrentUserByToken(token);
			setCurrentUser(user);
			chain.doFilter(request, response);
		} else {
			response.setContentLength(0);
			response.setStatus(STATUS_CODE_UNAUTHORISED);
		}
	}

	private void setCurrentUser(User user) {
		CurrentUserHolder PersonHolder = ApplicationContextProvider.getApplicationContext()
				.getBean(CurrentUserHolder.class);
		PersonHolder.setCurrentUser(user);
	}
}
