package udemy.mociktoin28minutes.buisness;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


public class ListTest {
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();       //Use this instead of RunWith(jUnitRunner)

	@Mock
	private List<String> list;

	@Test
	public void letsMockListSize() {
		when(list.size()).thenReturn(10);

		//THEN
		assertEquals(10, list.size());
	}

	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		when(list.size()).thenReturn(10).thenReturn(20);

		//THEN
		assertEquals(10, list.size()); // First Call
		assertEquals(20, list.size()); // Second Call
	}

	@Test
	public void letsMockListGet() {
		when(list.get(0)).thenReturn("in28Minutes");

		//THEN
		assertEquals("in28Minutes", list.get(0));
		assertNull(list.get(1));
	}

	@Test(expected = RuntimeException.class)
	public void letsMockListGetToThrowException() {
		when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("Something went wrong"));
		list.get(0);
	}

	@Test
	public void letsMockListGetWithAny() {
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("in28Minutes");
		// If you are using argument matchers, all arguments have to be provided by matchers.

		//THEN
		assertEquals("in28Minutes", list.get(0));
		assertEquals("in28Minutes", list.get(1));
	}

	@Test
	public void bddAliases_UsingGivenWillReturn() {
		//given
		BDDMockito.given(list.get(Mockito.anyInt())).willReturn("in28Minutes");

		//THEN
		assertThat("in28Minutes", is(list.get(0)));
		assertThat("in28Minutes", is(list.get(0)));
	}
}
