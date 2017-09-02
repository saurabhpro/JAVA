package udemy.mociktoin28minutes.data.api;

import java.util.List;


//Create TodoServiceStub
//Test TodoBusinessImpl using TodoServiceStub

public interface TodoService {
	List<String> retrieveTodoTasks(String user);

	void deleteTodo(String todo);
}
