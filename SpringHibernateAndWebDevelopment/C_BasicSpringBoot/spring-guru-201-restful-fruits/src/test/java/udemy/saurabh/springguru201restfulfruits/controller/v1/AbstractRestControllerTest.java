package udemy.saurabh.springguru201restfulfruits.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

abstract class AbstractRestControllerTest {

	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}