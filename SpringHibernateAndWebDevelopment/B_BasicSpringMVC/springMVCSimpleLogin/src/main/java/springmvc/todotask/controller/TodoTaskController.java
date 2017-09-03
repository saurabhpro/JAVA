package springmvc.todotask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import springmvc.todotask.service.TodoTaskService;

@Controller
public class TodoTaskController {

	//ServiceClass should not be initialized manually in this class, instead framework should inject it - why ?
	//! LoginService loginService = new LoginService();

	//instead using Autowiring,
	// PS- Field Autowiring is not recommended hence use constructor autowiring
	//! @Autowired
	private final TodoTaskService todoTaskService;

	@Autowired
	public TodoTaskController(TodoTaskService todoTaskService) {
		this.todoTaskService = todoTaskService;
	}

	@GetMapping(value = "/todoTasks")
	public String handleUserLogin(ModelMap model) {
		model.addAttribute("todoTasks", todoTaskService.retrieveTodoTasks("Saurabh"));
		return "todoTasks";

	}
}
