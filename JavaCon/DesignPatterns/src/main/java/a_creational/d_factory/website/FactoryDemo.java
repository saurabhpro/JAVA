package a_creational.d_factory.website;

public class FactoryDemo {

	public static void main(String[] args) {
		Website site = WebsiteFactory.getWebsite(WebsiteType.BLOG);

		if (site != null) {
			System.out.println(site.getPages());
		}


		site = WebsiteFactory.getWebsite(WebsiteType.SHOP);

		if (site != null) {
			System.out.println(site.getPages());
		}
	}

}
