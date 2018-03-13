package collection_n;

interface Comic<C> {
	void draw(C c);
}

class ComicClass<C> implements Comic<C> {
	@Override
	public void draw(C c) {
		System.out.println(c);
	}
}

class SnoopyClass implements Comic<SnoopyGenerics> {
	@Override
	public void draw(SnoopyGenerics c) {
		System.out.println(c);
	}
}

class SnoopyComic implements Comic<SnoopyGenerics> {

	@Override
	public void draw(SnoopyGenerics snoopy) {

	}
}

public class SnoopyGenerics {
	public static void main(String[] args) {
		Comic<SnoopyGenerics> c1 = c -> System.out.println(c);
		Comic<SnoopyGenerics> c2 = new ComicClass<>();
		Comic<SnoopyGenerics> c3 = new SnoopyClass();
		Comic<SnoopyGenerics> c4 = new SnoopyComic();
	}

}