package b_structural.c_composite.menu;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {

	String name;
	String url;
	List<MenuComponent> menuComponents = new ArrayList<>();

	public MenuComponent add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException("Feature not implemented at this level");
	}

	public MenuComponent remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException("Feature not implemented at this level");
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public abstract String toString();

	String print(MenuComponent menuComponent) {
		StringBuilder builder = new StringBuilder(menuComponent.name);
		builder.append(": ");
		builder.append(menuComponent.url);
		builder.append("\n");
		return builder.toString();
	}
}