package udemy.mociktoin28minutes.buisness;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import udemy.mociktoin28minutes.data.api.TodoService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)      //Instead of this we can use @Rule
public class TodoBusinessImplMockitoTest {

	@Mock
	private TodoService todoService;
	//TodoService todoService =  = mock(TodoService.class); //GIVEN STEP

	@InjectMocks
	private TodoBusinessImpl todoBusinessImpl;
	//TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService); //WHEN STEP

	@Captor
	private ArgumentCaptor<String> stringArgumentCaptor;
	//ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);


	private List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

	@Test
	public void usingMockito() {
		//GIVEN
		//1. Mock
		//2. todos arglist

		//WHEN
		when(todoService.retrieveTodos("Saurabh")).thenReturn(allTodos);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Saurabh");

		//THEN
		assertEquals(2, todos.size());
	}

	@Test
	public void usingMockito_UsingBDD() {
		//GIVEN
		//1. Mock
		//2. todos arglist
		BDDMockito.given(todoService.retrieveTodos("Saurabh")).willReturn(allTodos);

		//when
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Saurabh");

		//then
		assertThat(todos.size(), is(2));
	}

	@Test
	public void letsTestDeleteNow() {
		//GIVEN
		//1. Mock
		//2. todos arglist

		//WHEN
		when(todoService.retrieveTodos("Saurabh")).thenReturn(allTodos);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Saurabh");

		//THEN
		verify(todoService).deleteTodo("Learn to Dance");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance"); // atLeastOnce, atLeast
	}

	@Test
	public void captureArgument() {
		//WHEN
		when(todoService.retrieveTodos("Saurabh")).thenReturn(allTodos);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Saurabh");

		//THEN
		verify(todoService).deleteTodo(stringArgumentCaptor.capture());
		assertEquals("Learn to Dance", stringArgumentCaptor.getValue());
	}
}
