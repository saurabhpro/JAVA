package springmvc.todotask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import springmvc.todotask.service.TodoTaskService;

import java.util.Date;

@Controller
@SessionAttributes("name")
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
	public String showTodoTasksList(ModelMap model
	                                //, @RequestParam String name
	) {
		//model.addAttribute("name", name); //use sessionAttributes instead
		model.addAttribute("todoTasks", todoTaskService.retrieveTodoTasks("Saurabh"));
		return "todoTasks";
	}

	@GetMapping("/addTodoTask")
	public String showTodoPage() {
		return "todo";
	}

	@PostMapping(value = "/addTodoTask")
	public String addTodo(ModelMap model, @RequestParam String desc) {
		todoTaskService.addTodo((String) model.get("name"), desc, new Date(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:todoTasks";
	}


	@GetMapping(value = "/deleteTodoTask")
	public String deleteTodo(@RequestParam int id) {
		todoTaskService.deleteTodo(id);

		return "redirect:todoTasks";
	}
}
