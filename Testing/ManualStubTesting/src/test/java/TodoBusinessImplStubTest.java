import org.junit.Test;
import udemy.mociktoin28minutes.buisness.TodoBusinessImpl;
import udemy.mociktoin28minutes.data.api.TodoService;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodoTasksRelatedToSpring("Ranga");

		assertEquals(2, todos.size());
	}
}
