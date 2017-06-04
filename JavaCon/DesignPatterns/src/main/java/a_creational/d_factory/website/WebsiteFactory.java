package a_creational.d_factory.website;

import a_creational.d_factory.website.blog.Blog;
import a_creational.d_factory.website.shop.Shop;

class WebsiteFactory {

	static Website getWebsite(WebsiteType siteType) {
		switch (siteType) {
			case BLOG: {
				return new Blog();
			}

			case SHOP: {
				return new Shop();
			}

			default: {
				return null;
			}
		}
	}

}
