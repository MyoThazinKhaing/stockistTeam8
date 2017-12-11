package sg.edu.iss.team8.controller;

//testing conflicts
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.iss.team8.exception.UserNotFound;
import sg.edu.iss.team8.model.User;
//import sg.edu.iss.team8.service.EmployeeService;
import sg.edu.iss.team8.service.UserService;
import sg.edu.iss.team8.validator.UserValidator;

@RequestMapping(value = "/admin/user")
@Controller
public class AdminUserController {

	@Autowired
	private UserService uService;
	// @Autowired
	// private EmployeeService eService;
	@Autowired
	private UserValidator uValidator;

	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	}

	/**
	 * USER CRUD OPERATIONS
	 * 
	 * @return
	 */

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	@RequestMapping(value = "/**", method = RequestMethod.GET)
	public String firstTime(HttpServletRequest request, HttpSession session) {
		Map<RequestMappingInfo, HandlerMethod> mapping = requestMappingHandlerMapping.getHandlerMethods();
		return new TestController().testURL(request, session, mapping); 
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newUserPage(HttpSession session, RedirectAttributes redirect) {
		if (!new TestController().isAdmin(session))
			return new ModelAndView("403");
		ModelAndView mav = new ModelAndView("adduser", "user", new User());
		ArrayList<User> userList = uService.findAllUsers();
		mav.addObject("userList", userList);
		ArrayList<String> eidList = uService.ListRoles();
		mav.addObject("eidlist", eidList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) {
		if (!new TestController().isAdmin(session))
			return new ModelAndView("403");
		
		ModelAndView mav = new ModelAndView("adduser");
		boolean isRepeat = false;
		if(uService.findUser(user.getUsername())!=null) {
			isRepeat=true;
			mav.addObject("repeatUser", isRepeat);
		}
		if (result.hasErrors() || isRepeat) {
			ArrayList<String> eidList = uService.ListRoles();
			mav.addObject("eidlist", eidList);
			return mav;
		}
			
		String message = "The user " + user.getUsername() + " was successfully created.";

		uService.createUser(user);
		mav.setViewName("redirect:/admin/user/create");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView userListPage(HttpSession session) {
		if (!new TestController().isAdmin(session))
			return new ModelAndView("403");
		ModelAndView mav = new ModelAndView("manageuser");
		List<User> userList = uService.findAllUsers();
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable String id, HttpSession session) {
		if (!new TestController().isAdmin(session))
			return new ModelAndView("403");
		ModelAndView mav = new ModelAndView("edituser");
		User user = uService.findUser(id);
		mav.addObject("user", user);
		ArrayList<String> eidList = uService.ListRoles();
		mav.addObject("eidlist", eidList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid User user, BindingResult result, @PathVariable String id,
			final RedirectAttributes redirectAttributes, HttpSession session) throws UserNotFound {
		if (!new TestController().isAdmin(session))
			return new ModelAndView("403");

		if (result.hasErrors())
			return new ModelAndView("edituser");

		ModelAndView mav = new ModelAndView("redirect:/admin/user/list");
		String message = "error";

		uService.changeUser(user);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable String id, final RedirectAttributes redirectAttributes, HttpSession session)
			throws UserNotFound {
		if (!new TestController().isAdmin(session))
			return new ModelAndView("403");
		ModelAndView mav = new ModelAndView("redirect:/admin/user/list");
		User user = uService.findUser(id);
		uService.removeUser(user);
		String message = "The user " + user.getUsername() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}
