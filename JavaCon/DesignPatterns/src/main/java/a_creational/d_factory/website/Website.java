package a_creational.d_factory.website;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {

	protected final List<Page> pages = new ArrayList<>();

	protected Website() {
		this.createWebsite();
	}

	public List<Page> getPages() {
		return pages;
	}

	protected abstract void createWebsite();

}
