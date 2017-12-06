package arrayList;

import java.util.Collection;
import java.util.List;

public class CollectionConverter {
	<T> List<T> toList(Collection<T> c) {
		return null;
	}
}


class Overrider extends CollectionConverter {
	List toList(Collection c) {
		return null;
	}
}