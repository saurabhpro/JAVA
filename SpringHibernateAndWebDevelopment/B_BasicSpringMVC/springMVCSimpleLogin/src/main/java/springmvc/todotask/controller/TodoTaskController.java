package springmvc.todotask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import springmvc.todotask.model.TodoTask;
import springmvc.todotask.service.TodoTaskService;

import javax.validation.Valid;
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

	/**
	 * loads the add todo task page
	 *
	 * @return
	 */
	@GetMapping("/addTodoTask")
	public String showTodoPage(ModelMap modelMap) {
		modelMap.addAttribute("todoTask", new TodoTask(0, "Saurabh", "Default", new Date(), false));
		return "todo";
	}

	@PostMapping(value = "/addTodoTask")
	public String addTodo(ModelMap model,
	                      //@RequestParam String desc //if you want more variables, baar baar likhna padta ...instead used pura object
	                      @Valid TodoTask todoTask, /*iski wajah se default constructor chiye*/
	                      BindingResult result /*this object will hold all validation checks*/) {

		if (result.hasErrors()) {
			return "todo";
		}

		todoTaskService.addTodo((String) model.get("name"), todoTask.getDesc(), new Date(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:todoTasks";
	}


	@GetMapping(value = "/deleteTodoTask")
	public String deleteTodo(@RequestParam int id) {
		todoTaskService.deleteTodo(id);

		return "redirect:todoTasks";
	}
}
