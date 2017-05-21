package testing.junit.m5.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import testing.junit.m5.common.SalesRepositoryBase;

import java.io.PrintStream;

public class SalesModule extends AbstractModule {

	private final String fileLocation;

	public SalesModule(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	@Override
	protected void configure() {
		bind(String.class)
				.annotatedWith(Names.named("fileLocation"))
				.toInstance(fileLocation);

		bind(PrintStream.class).toInstance(System.out);
		bind(SalesRepositoryBase.class).to(testing.junit.m5.guice.CsvSalesRepository.class);
	}

}
