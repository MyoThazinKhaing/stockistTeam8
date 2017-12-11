package sg.edu.iss.team8.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import sg.edu.iss.team8.model.User;
import sg.edu.iss.team8.service.UserService;

public class TestController {
	public String testURL(HttpServletRequest request, HttpSession session,
			Map<RequestMappingInfo, HandlerMethod> mapping) {
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

		for (Map.Entry<RequestMappingInfo, HandlerMethod> info : mapping.entrySet()) {
			if (info.getKey().getName() == path) {
				if (session.getAttribute("USERSESSION") != null) {
					return "redirect:" + path;
				} else {
					return "403";
				}
			}
		}
		return "404";
	}

	public boolean hasSession(HttpSession session) {
		if (session.getAttributeNames().hasMoreElements()) {
			return true;
		}
		return false;
	}

	public boolean isAdmin(HttpSession session) {
		if (isUser(session)) {
			UserSession us = (UserSession) session.getAttribute("USERSESSION");
			if (us.getUser().getRole().equalsIgnoreCase("admin")) {
				return true;
			}
		}
		return false;
	}

	public boolean isMech(HttpSession session) {
		if(isUser(session)) {
			UserSession us = (UserSession) session.getAttribute("USERSESSION");
			if(us.getUser().getRole().equalsIgnoreCase("mechanic")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isUser(HttpSession session) {
		if(hasSession(session)) {
			UserSession us = (UserSession) session.getAttribute("USERSESSION");
			if(us!=null) {
				return true;
			}
		}
		return false;
	}
}
