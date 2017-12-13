package sg.edu.iss.team8.controller;

import java.util.ArrayList;
import java.util.Calendar;

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

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.edu.iss.team8.model.Damage;
import sg.edu.iss.team8.model.Product;
import sg.edu.iss.team8.service.DamageService;
import sg.edu.iss.team8.service.ProductService;
import sg.edu.iss.team8.validator.DamageValidator;

@RequestMapping(value = "/admin/damage")
@Controller
public class DamageController {
	@Autowired
	private ProductService pService;

	@Autowired
	private DamageService dService;

	@Autowired
	private DamageValidator dValidator;

	@InitBinder("damage")
	private void initEmployeeBinder(WebDataBinder binder) {
		binder.addValidators(dValidator);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView damageListPage() {
		ModelAndView mav = new ModelAndView("damage-list", "damage", new Damage());
		ArrayList<Damage> damageList = (ArrayList<Damage>) dService.findAllDamage();
		int[] plist = new int[] { 3652, 3653, 3654, 3655 };
		mav.addObject("plist", plist);
		mav.addObject("damageList", damageList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newDamagePage() {
		Damage d = new Damage();
		ArrayList<String> slist = new ArrayList<String>();
		slist.add("received");
		slist.add("sent");
		ModelAndView mav = new ModelAndView("damage-new", "damage", d);
		int[] plist = new int[] { 3652, 3653, 3654, 3655 };
		mav.addObject("plist", plist);
		mav.addObject("slist", slist);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid Damage damage, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("damage-new");
			ArrayList<String> slist = new ArrayList<String>();
			slist.add("received");
			slist.add("sent");
			int[] plist = new int[] { 3652, 3653, 3654, 3655 };
			mav.addObject("plist", plist);
			mav.addObject("slist", slist);

			return mav;
		}
		ModelAndView mav = new ModelAndView();
		String message = "New record  was successfully created.";
		
		damage.setStatus("sent");
		dService.createDamage(damage);
		pService.reduceStock(damage.getPartNumber(), damage.getQuantity());
		mav.setViewName("redirect:/admin/damage/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/received/{id}", method = RequestMethod.GET)
	public ModelAndView receivedReplacedDamage(@PathVariable int id, final RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView("redirect:/admin/damage/list");
		Damage damage = dService.findDamage(id);
		damage.setStatus("received");
		damage.setSendDate(Calendar.getInstance().getTime());
		dService.changeDamage(damage);
		//Product product = pService.findProduct(id);
		pService.increaseStock(id, damage.getQuantity());
		String message = "The products have been received.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDamage(@PathVariable int id, final RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView("redirect:/admin/damage/list");
		Damage damage = dService.findDamage(id);
		dService.removeDamage(damage);
		String message = "The employee was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editEmployee(@ModelAttribute @Valid Damage damage, BindingResult result, @PathVariable int id,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {

			ModelAndView mav = new ModelAndView("damage-edit");
			ArrayList<String> slist = new ArrayList<String>();
			slist.add("received");
			slist.add("sent");

			mav.addObject("slist", slist);

			return mav;
		}

		ModelAndView mav = new ModelAndView("redirect:/admin/damage/list");
		String message = "Record was successfully updated.";
		dService.changeDamage(damage);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployeePage(@PathVariable int id) {
		ArrayList<String> slist = new ArrayList<String>();
		slist.add("received");
		slist.add("sent");
		ModelAndView mav = new ModelAndView("damage-edit");
		Damage damage = dService.findDamage(id);
		mav.addObject("damage", damage);
		mav.addObject("slist", slist);
		return mav;
	}

	/*
	 * @RequestMapping(value = "/search", method = RequestMethod.GET) public
	 * ModelAndView damageListByPnumPage(@RequestParam int pnum) {
	 * 
	 * ModelAndView mav = new ModelAndView("damage-listbypnum"); ArrayList<Damage>
	 * damageList =(ArrayList<Damage>)dService.findCoursesByPNUM(pnum);
	 * mav.addObject("damageList",damageList); return mav; }
	 */

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView damageListByPnumPage(@ModelAttribute @Valid Damage damage, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView("damage-list");
		ArrayList<Damage> damageList = (ArrayList<Damage>) dService.findCoursesByPNUM(damage.getPartNumber());
		int[] plist = new int[] { 3652, 3653, 3654, 3655 };
		mav.addObject("plist", plist);
		mav.addObject("damageList", damageList);
		return mav;
	}

}
