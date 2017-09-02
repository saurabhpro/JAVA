package udemy.mociktoin28minutes.data.api;

import java.util.List;

public interface TodoService {
	List<String> retrieveTodoTasks(String user);

	void deleteTodo(String todo);
}
