package sg.edu.iss.team8.controller;

import java.util.*;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.method.HandlerMethod;

import sg.edu.iss.team8.exception.UserNotFound;
import sg.edu.iss.team8.model.User;
import sg.edu.iss.team8.service.UserService;

@Controller
public class CommonController {

	@Autowired
	private UserService uService;

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@RequestMapping(value = {"/*","/**"}, method = RequestMethod.GET)
	public String general(HttpServletRequest request, HttpSession session) {
		return "redirect:/login";
	}
	
	@RequestMapping(value = "restricted", method = RequestMethod.GET)
	public String restricted(HttpServletRequest request, HttpSession session) {
		return "403";
	}
	
	@RequestMapping(value = "notfound", method = RequestMethod.GET)
	public String notfound(HttpServletRequest request, HttpSession session) {
		return "404";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mav, HttpSession session) {
		if (session.getAttribute("USERSESSION") == null) {
			mav.addObject("user", new User());
		}
		if(session.getAttribute("AUTHENTICATE") == "fail") {
			session.setAttribute("LOGIN", "fail");
			session.setAttribute("AUTHENTICATE", "");
		}else {
			session.setAttribute("LOGIN", "");
		}
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("404");
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
		session.setAttribute("AUTHENTICATE", "fail");
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		if (session.getAttribute("USERSESSION") != null) {
			session.removeAttribute("USERSESSION");
		}

		ModelAndView mav = new ModelAndView("redirect:/login");
		return mav;
	}
	
	@RequestMapping(value = "/changepw/{id}", method = RequestMethod.GET)
	public ModelAndView changepwUserPage(@PathVariable String id, HttpSession session) {
/*		if (!new TestController().isUser(session))
			return new ModelAndView("403");*/
		ModelAndView mav = new ModelAndView("changepassword");
		User user = uService.findUser(id);
		mav.addObject("user", user);
		ArrayList<String> eidList = uService.ListRoles();
		mav.addObject("eidlist", eidList);
		return mav;
	}

	@RequestMapping(value = "/changepw/{id}", method = RequestMethod.POST)
	public ModelAndView changepwUser(@ModelAttribute @Valid User user, BindingResult result, @PathVariable String id,
			final RedirectAttributes redirectAttributes, HttpSession session) throws UserNotFound {

		ModelAndView mav = new ModelAndView("redirect:/changepw/"+id);
		
		if (result.hasErrors()) {
			ArrayList<String> eidList = uService.ListRoles();
			mav.addObject("eidlist", eidList);
			String[] statusList = uService.ListStatus();
			mav.addObject("statuslist", statusList);
			return mav;
		}
		
		String message = "The user " + user.getUsername() + " was successfully created.";

		uService.changeUser(user);


		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	

}