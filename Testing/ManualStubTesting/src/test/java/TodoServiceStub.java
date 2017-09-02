
import mociktoin28minutes.data.api.TodoService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by saurabhkumar on 02/09/17.
 */
public class TodoServiceStub implements TodoService {
	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
	}

	@Override
	public void deleteTodo(String todo) {
	}
}
