package lab.mvc;

import lab.model.simple.SimpleUser;
import lab.model.User;
import lab.mvc.form.bean.UserFormBean;
import lab.services.PersonService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Log
@Controller
@RequestMapping("/adduser.form")
public class UserFormController {
	
	private PersonService userService;

	@ModelAttribute("userFormBean")
	public UserFormBean getUserFormBean() {
		return new UserFormBean();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "adduserform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(@Valid UserFormBean userFormBean, Errors errors) {
		
		if (errors.hasErrors()) {

			log.info("Adduserform validation failed.");
			return  new ModelAndView("adduserform");
		} else {
			
			List<User> userList;
			SimpleUser user = new SimpleUser();
			user.setFirstName(userFormBean.getFirstName());
			user.setLastName(userFormBean.getLastName());

			log.info(() -> "Adding new "+ user);
			
			userService.saveUser(user);
			userList = userService.loadAllUsers();
			
			ModelAndView mav = new ModelAndView("userlistview");
			mav.addObject("userList", userList);
			
			return mav;
		}
	}	
	
	@Autowired
	@Required
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}