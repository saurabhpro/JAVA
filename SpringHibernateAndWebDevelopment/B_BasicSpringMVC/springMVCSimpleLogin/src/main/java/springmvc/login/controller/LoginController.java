package springmvc.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.login.service.LoginService;

@Controller
public class LoginController {

	//ServiceClass should not be initialized manually in this class, instead framework should inject it - why ?
	//! LoginService loginService = new LoginService();

	//instead using Autowiring,
	// PS- Field Autowiring is not recommended hence use constructor autowiring
	//! @Autowired
	private final LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model,
	                              @RequestParam String name,
	                              @RequestParam String password) {
		if (loginService.validateUser(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		} else {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
	}
}
