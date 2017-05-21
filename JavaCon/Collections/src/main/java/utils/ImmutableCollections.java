package utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by saurabhkumar on 20/05/17.
 */
public class ImmutableCollections {

	public static void main(String[] args) {
		Collections.emptyList();
		Collections.emptySet();
		Collections.emptyMap();

		List list = Collections.singletonList(1);
		Set set = Collections.singleton(1);
		Map map = Collections.singletonMap(1, "Val");
	}
}
