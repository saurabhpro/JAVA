package udemy.mociktoin28minutes.data.api;

import java.util.List;

/**
 * Created by saurabhkumar on 02/09/17.
 */
public interface TodoService {
	List<String> retrieveTodos(String user);

	void deleteTodo(String todo);
}
