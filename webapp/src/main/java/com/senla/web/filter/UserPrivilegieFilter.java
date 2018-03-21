package com.senla.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.RequestContextFilter;

import com.senla.holder.support.CurrentUserSupport;
import com.senla.web.util.PrivilegiesManager;

public class UserPrivilegieFilter extends RequestContextFilter implements CurrentUserSupport {
	private static final Integer STATUS_CODE_FORBIDDEN = 403;

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String path = request.getServletPath();
		if (PrivilegiesManager.checkPrivilegie(path.replaceAll("[0-9]+", "*"), getCurrentUser().getRole())) {
			chain.doFilter(request, response);
		} else {
			response.setContentLength(0);
			response.setStatus(STATUS_CODE_FORBIDDEN);
		}
	}
}
