package sg.edu.iss.team8.validator;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import sg.edu.iss.team8.controller.UserSession;

public class MappingInterceptor extends HandlerInterceptorAdapter {
	
	private boolean hasCheckedUser = false;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// all paths obtained here does not include query string
		// gets requestUri which contains context path + servlet path /team8/user/create
		String requestUri = request.getRequestURI();

		// get only context path e.g. /team8
		String contextPath = request.getContextPath();

		// get only servlet path e.g. /user/create
		String servletPath = request.getServletPath();

		// get all request mapping paths
		/*
		 * Map<RequestMappingInfo, HandlerMethod> mapping =
		 * requestMappingHandlerMapping.getHandlerMethods();
		 */

		// check if uri is contextpath eg. /StockistTeam8
/*		if (requestUri.equals(contextPath + servletPath)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}*/

		// check and allow if uri is public accessible
/*		if (isPublicPage(requestUri)) {
			return true;
		}*/
		
		if(requestUri.equals(request.getContextPath() + "/login")) {
			return true;
		}

		// if user is not logged in
		if (request.getSession().getAttribute("USERSESSION") == null) {			
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		} 
		
		// if user is logged in, get user session to get user
		UserSession us = (UserSession) request.getSession().getAttribute("USERSESSION");
		// check if uri is only accessible by admin
		if (isAdminOnly(requestUri)) {
			// if only accessible by admin, check user role is admin
			if (us.getUser().getRole().equals("admin")) {
				// if user is admin, do nothing, allow to pass
				return true;
			} else { // otherwise is user is not admin, redirect to restricted
				response.sendRedirect(request.getContextPath() + "/restricted");
				return false;
			}
		} else { // uri is accessible by all users, do nothing, allow to pass
			return true;
		}
/*
		// if all logic fails to catch uri, return not found
		response.sendRedirect(request.getContextPath() + "/notfound");
		return false;*/
	}
/*
	private boolean isPublicPage(String uri) {
		return MappingValidator.PUBLIC.parallel().anyMatch(uri::equals);
	}*/

	private boolean isAdminOnly(String uri) {
		Stream<String> ss = Arrays.stream(MappingValidator.ADMIN_ONLY);
		return ss.anyMatch(uri::contains);
	}

}
