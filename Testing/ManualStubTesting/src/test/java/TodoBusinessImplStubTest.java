
import org.junit.jupiter.api.Test;
import udemy.mociktoin28minutes.buisness.TodoBusinessImpl;
import udemy.mociktoin28minutes.data.api.TodoService;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todoTasks = todoBusinessImpl.retrieveTodoTasksRelatedToSpring("Saurabh");

		assertEquals(2, todoTasks.size());
	}

	@Test
	public void usingAStubToCheckListItems() {
		TodoService todoService = new TodoServiceStub();

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todoTasks = todoBusinessImpl.retrieveTodoTasksRelatedToSpring("Saurabh");

		assertThat(todoTasks, hasItems("Learn Spring MVC", "Learn Spring"));
	}
}
