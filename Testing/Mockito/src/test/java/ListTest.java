import org.junit.Rule;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.InvalidUseOfMatchersException;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
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

		assertNull(list.get(1));    //if un-stubbed value is called
	}

	@Test(expected = RuntimeException.class)
	public void letsMockListGetToThrowException() {
		when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("Something went wrong"));
		list.get(0);
	}

	@Test
	public void letsMockListGetWithAny() {
		//Argument Matcher
		when(list.get(Mockito.anyInt())).thenReturn("in28Minutes");

		//THEN
		assertEquals("in28Minutes", list.get(0));
		assertEquals("in28Minutes", list.get(1));
	}

	@Test(expected = InvalidUseOfMatchersException.class)
	public void letsMockListGetWithMixedStubValues() {
		when(list.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something went wrong"));
		// If you are using argument matchers, all arguments have to be provided by matchers.

		//THEN
		assertEquals("in28Minutes", list.get(0));
		assertEquals("in28Minutes", list.get(1));
	}

	@Test
	public void letsMockListGetWithMixedStubValuesButHamcrestWorkaround() {
		when(list.subList(anyInt(), eq(5))).thenReturn(Collections.singletonList("Something"));

		//THEN
		assertEquals("Something", list.subList(0, 5).get(0));
		//assertEquals(null, list.subList(0,5).get(1)); Index out of bounds
	}

	@Test
	public void bddAliases_UsingGivenWillReturn() {
		//given
		BDDMockito.given(list.get(Mockito.anyInt())).willReturn("in28Minutes");

		//THEN
		assertThat("in28Minutes", is(list.get(0)));
		assertThat("in28Minutes", is(list.get(1)));
	}
}
