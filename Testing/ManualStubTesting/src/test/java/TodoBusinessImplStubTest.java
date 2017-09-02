import org.junit.Test;
import udemy.mociktoin28minutes.buisness.TodoBusinessImpl;
import udemy.mociktoin28minutes.data.api.TodoService;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


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
