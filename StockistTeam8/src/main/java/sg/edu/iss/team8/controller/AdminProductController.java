package sg.edu.iss.team8.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.model.User;
import sg.edu.iss.team8.service.ProductService;

@Controller
@RequestMapping(value = "/product")
public class AdminProductController {
	
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	@RequestMapping(value = "/**", method = RequestMethod.GET)
	public String firstTime(HttpServletRequest request, HttpSession session) {
		Map<RequestMappingInfo, HandlerMethod> mapping = requestMappingHandlerMapping.getHandlerMethods();
		return new TestController().testURL(request, session, mapping); 
	}

	@RequestMapping(value = "/catalog")
	public ModelAndView viewProductCatalog(HttpSession session) {
		if(!new TestController().isUser(session)) {
			return new ModelAndView("403");
		}
		return new ModelAndView("products-catalog");
		/*if (us.getSessionId() != null) {
			ModelAndView mav = new ModelAndView("products-catalog");
			
			 * mav.addObject("chistory",
			 * cService.findCoursesByEID(us.getEmployee().getEmployeeId()));
			 
			return mav;
		}
		return new ModelAndView("error");*/

	}

	/*
	 * @Autowired private CourseService cService;
	 * 
	 * @Autowired private CourseValidator cValidator;
	 * 
	 * @Autowired private CourseEventService ceService;
	 * 
	 * @InitBinder("course") private void initCourseBinder(WebDataBinder binder) {
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 * dateFormat.setLenient(false); binder.registerCustomEditor(Date.class, new
	 * CustomDateEditor(dateFormat, false)); //binder.addValidators(cValidator);
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/logout") public String logout(HttpSession session)
	 * { session.invalidate(); return "redirect:/home/login";
	 * 
	 * }
	 * 
	 *//**
		 * COURSE CRUD OPERATIONS
		 * 
		 * @return
		 *//*
			 * 
			 * @RequestMapping(value = "/history") public ModelAndView
			 * employeeCourseHistory(HttpSession session) { UserSession us = (UserSession)
			 * session.getAttribute("USERSESSION"); ModelAndView mav = new
			 * ModelAndView("login"); if (us.getSessionId() != null) { mav = new
			 * ModelAndView("/staff-course-history"); mav.addObject("chistory",
			 * cService.findCoursesByEID(us.getEmployee().getEmployeeId())); return mav; }
			 * return mav;
			 * 
			 * }
			 * 
			 * @RequestMapping(value = "/course/create", method = RequestMethod.GET) public
			 * ModelAndView newCoursePage() { ModelAndView mav = new
			 * ModelAndView("staff-course-new"); mav.addObject("course", new Course());
			 * return mav; }
			 * 
			 * @RequestMapping(value = "/course/create", method = RequestMethod.POST) public
			 * ModelAndView createNewCourse(@ModelAttribute @Valid Course course,
			 * BindingResult result, final RedirectAttributes redirectAttributes,
			 * HttpSession session) {
			 * 
			 * if (result.hasErrors()) return new ModelAndView("staff-course-new");
			 * 
			 * ModelAndView mav = new ModelAndView(); String message = "New course " +
			 * course.getCourseId() + " was successfully created."; UserSession us =
			 * (UserSession) session.getAttribute("USERSESSION");
			 * course.setEmployeeId(us.getEmployee().getEmployeeId());
			 * course.setStatus(Course.SUBMITTED);
			 * mav.setViewName("redirect:/staff/history"); CourseEvent ce = new
			 * CourseEvent(); ce.setCourse(course);
			 * ce.setEventBy(us.getEmployee().getEmployeeId());
			 * ce.setEventType(Course.SUBMITTED);
			 * ce.setTimeStamp(Calendar.getInstance().getTime());
			 * cService.createCourse(course); ceService.createCourseEvent(ce);
			 * redirectAttributes.addFlashAttribute("message", message); return mav; }
			 * 
			 * @RequestMapping(value = "/course/edit/{id}", method = RequestMethod.GET)
			 * public ModelAndView editCoursePage(@PathVariable Integer id) { ModelAndView
			 * mav = new ModelAndView("staff-course-edit"); Course course =
			 * cService.findCourse(id); mav.addObject("course", course); return mav; }
			 * 
			 * @RequestMapping(value = "/course/edit/{id}", method = RequestMethod.POST)
			 * public ModelAndView editCourse(@ModelAttribute @Valid Course course,
			 * BindingResult result, @PathVariable Integer id, final RedirectAttributes
			 * redirectAttributes, HttpSession session) throws CourseNotFound { if
			 * (result.hasErrors()) return new ModelAndView("staff-course-edit");
			 * ModelAndView mav = new ModelAndView(); System.out.println("DATES****" +
			 * course.getFromDate() + course.getToDate()); String message = "New course " +
			 * course.getCourseId() + " was successfully created."; UserSession us =
			 * (UserSession) session.getAttribute("USERSESSION");
			 * course.setEmployeeId(us.getEmployee().getEmployeeId());
			 * course.setStatus(Course.UPDATED); mav.setViewName("redirect:/staff/history");
			 * CourseEvent ce = new CourseEvent(); ce.setCourse(course);
			 * ce.setEventBy(us.getEmployee().getEmployeeId());
			 * ce.setEventType(Course.UPDATED);
			 * ce.setTimeStamp(Calendar.getInstance().getTime());
			 * cService.changeCourse(course); ceService.createCourseEvent(ce);
			 * redirectAttributes.addFlashAttribute("message", message); return mav; }
			 * 
			 * @RequestMapping(value = "/course/withdraw/{id}", method = RequestMethod.GET)
			 * public ModelAndView deleteCourse(@PathVariable Integer id, final
			 * RedirectAttributes redirectAttributes, HttpSession session) throws
			 * CourseNotFound {
			 * 
			 * ModelAndView mav = new ModelAndView("redirect:/staff/history"); Course course
			 * = cService.findCourse(id); String message = "Course " + course.getCourseId()
			 * + " was successfully withdrawn."; UserSession us = (UserSession)
			 * session.getAttribute("USERSESSION"); course.setStatus(Course.WITHDRAWN);
			 * CourseEvent ce = new CourseEvent(); ce.setCourse(course);
			 * ce.setEventBy(us.getEmployee().getEmployeeId());
			 * ce.setEventType(Course.WITHDRAWN);
			 * ce.setTimeStamp(Calendar.getInstance().getTime());
			 * cService.changeCourse(course); ceService.createCourseEvent(ce);
			 * redirectAttributes.addFlashAttribute("message", message); return mav; }
			 */
	@Autowired
	private ProductService pService;

	@RequestMapping(value = "/catalogue", method = RequestMethod.GET)
	public ModelAndView browseCatalogue(HttpSession session, Model model) {
		//UserSession us = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("/product-catalogue");
		mav.addObject("pList", pService.findAllProducts());
		model.addAttribute("product", new Product());
		return mav;
	}
	
	 @RequestMapping(value="/search", method = RequestMethod.POST)
	    public ModelAndView searchByDescription(
	    		@RequestParam String criteria,
	            @RequestParam String description) {
	        return new ModelAndView("product-catalogue", "pList", pService.searchProducts(criteria, description));
	        //return new ModelAndView("product-catalogue", "pList", pService.searchProduct("p.criteria",description));
	    }
	 }
