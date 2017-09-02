import mociktoin28minutes.buisness.TodoBusinessImpl;
import mociktoin28minutes.data.api.TodoService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by saurabhkumar on 02/09/17.
 */
public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");

		assertEquals(2, todos.size());
	}
}
