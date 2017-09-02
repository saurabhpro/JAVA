package udemy.mociktoin28minutes.buisness;

import udemy.mociktoin28minutes.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;


public class TodoBusinessImpl {
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodoTasksRelatedToSpring(String user) {
		List<String> filteredTodoTasks = new ArrayList<>();
		List<String> allTodoTasks = todoService.retrieveTodoTasks(user);
		for (String todo : allTodoTasks) {
			if (todo.contains("Spring")) {
				filteredTodoTasks.add(todo);
			}
		}
		return filteredTodoTasks;
	}

	public void deleteTodoTasksNotRelatedToSpring(String user) {
		List<String> allTodoTasks = todoService.retrieveTodoTasks(user);
		for (String todo : allTodoTasks) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
}
