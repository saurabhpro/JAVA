package springmvc.todotask.service;

import org.springframework.stereotype.Service;
import springmvc.todotask.model.TodoTask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoTaskService {
	private static List<TodoTask> todoTasks = new ArrayList<>();
	private static int todoCount = 3;

	static {
		todoTasks.add(new TodoTask(1, "Saurabh", "Learn Spring MVC", new Date(), false));
		todoTasks.add(new TodoTask(2, "Saurabh", "Learn Struts", new Date(), false));
		todoTasks.add(new TodoTask(3, "Saurabh", "Learn Hibernate", new Date(), false));
	}


	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todoTasks.add(new TodoTask(++todoCount, name, desc, targetDate, isDone));
	}

	public List<TodoTask> retrieveTodoTasks(String user) {
		List<TodoTask> filteredTodoTasks = new ArrayList<TodoTask>();
		for (TodoTask todo : todoTasks) {
			if (todo.getUser().equalsIgnoreCase(user))
				filteredTodoTasks.add(todo);
		}
		return filteredTodoTasks;
	}

	public void deleteTodo(int id) {
		/*
		See below for compact implementation
		Iterator<TodoTask> iterator = todoTasks.iterator();
		while (iterator.hasNext()) {
			TodoTask todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}*/
		todoTasks.removeIf(todo -> todo.getId() == id);
	}

	public TodoTask retrieveTodoTask(int id) {
		for (TodoTask todo : todoTasks) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(TodoTask todo) {
		todoTasks.remove(todo);
		todoTasks.add(todo);
	}
}
