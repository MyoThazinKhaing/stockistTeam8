package sg.edu.iss.team8.controller;

import java.util.*;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.method.HandlerMethod;

import sg.edu.iss.team8.model.User;
import sg.edu.iss.team8.service.UserService;

@Controller
public class CommonController {

	@Autowired
	private UserService uService;

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@RequestMapping(value = "/**", method = RequestMethod.GET)
	public String firstTime(HttpServletRequest request, HttpSession session) {
		Map<RequestMappingInfo, HandlerMethod> mapping = requestMappingHandlerMapping.getHandlerMethods();
		return new TestController().testURL(request, session, mapping);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mav, HttpSession session, @RequestParam(value = "error", required = false) String error) {
		if (session.getAttribute("USERNAME") == null) {
			mav.addObject("user", new User());
		} 
		if (!mav.getModel().containsKey("error")) {
			mav.addObject("error", "");
		}
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("error");
		}
		UserSession us = new UserSession();
		if (user.getUsername() != null && user.getPassword() != null) {
			User u = uService.authenticate(user.getUsername(), user.getPassword());
			if (u != null) {
				us.setUser(u);
				// PUT CODE FOR SETTING SESSION ID
				us.setSessionId(session.getId());
				session.setAttribute("USERSESSION", us);
				return new ModelAndView("redirect:/product/catalogue");
			}
		}
		return new ModelAndView("redirect:/login", "error", "Invalid name or password!");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		if (session.getAttribute("USERSESSION") != null) {
			session.removeAttribute("USERSESSION");
		}

		ModelAndView mav = new ModelAndView("redirect:/login");
		return mav;
	}

	/*
	 * @RequestMapping(value = { "/", "/welcome**", "/login"}, method =
	 * RequestMethod.GET) public ModelAndView login(@RequestParam(value = "error",
	 * required = false) String error,
	 * 
	 * @RequestParam(value = "logout", required = false) String logout) {
	 * 
	 * ModelAndView model = new ModelAndView(); if (error != null) {
	 * model.addObject("error", "Invalid username and password!"); }
	 * 
	 * if (logout != null) { model.addObject("msg",
	 * "You've been logged out successfully."); } model.setViewName("login");
	 * 
	 * return model;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = { "/login"}, method = RequestMethod.POST) public
	 * ModelAndView loginPost(@RequestParam(value = "error", required = false)
	 * String error,
	 * 
	 * @RequestParam(value = "logout", required = false) String logout) { return new
	 * ModelAndView("error"); }
	 * 
	 * 
	 * //for 403 access denied page
	 * 
	 * @RequestMapping(value = "/403", method = RequestMethod.GET) public
	 * ModelAndView accesssDenied() {
	 * 
	 * ModelAndView model = new ModelAndView();
	 * 
	 * //check if user is login Authentication auth =
	 * SecurityContextHolder.getContext().getAuthentication(); if (!(auth instanceof
	 * AnonymousAuthenticationToken)) { UserDetails userDetail = (UserDetails)
	 * auth.getPrincipal(); model.addObject("username", userDetail.getUsername()); }
	 * 
	 * model.setViewName("403"); return model;
	 * 
	 * }
	 */

}