import udemy.mociktoin28minutes.data.api.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
	// Dynamic Condition
	// Service Definition

	@Override
	public List<String> retrieveTodoTasks(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}

	@Override
	public void deleteTodo(String todo) {
	}
}
