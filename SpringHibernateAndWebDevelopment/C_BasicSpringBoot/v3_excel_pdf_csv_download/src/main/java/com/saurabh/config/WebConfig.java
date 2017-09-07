package com.saurabh.config;

import com.saurabh.viewResolver.CsvViewResolver;
import com.saurabh.viewResolver.ExcelViewResolver;
import com.saurabh.viewResolver.PdfViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@ComponentScan(basePackages = {"com.saurabh"})
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * set the default media type to TEXT_JSON in absence of file extension or when the filetype is unknown.
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
				.defaultContentType(MediaType.APPLICATION_JSON)
				.favorPathExtension(true);
	}

	/**
	 * Configure ContentNegotiatingViewResolver
	 * <p>
	 * Tells web controllers to return ModelAndViews or view names and based on various criteria,
	 * choose the right data representation strategy.
	 *
	 * @see com.saurabh.controller.ExportController download()
	 */
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();

		//will be injected by Spring, and different resolvers for each possible output format our application might produce.
		resolver.setContentNegotiationManager(manager);

		// Define all possible view resolvers
		List<ViewResolver> resolvers = new ArrayList<>();

		//NOTE: This order specifies which type will load on /download
		resolvers.add(excelViewResolver());
		resolvers.add(csvViewResolver());
		resolvers.add(pdfViewResolver());

		resolver.setViewResolvers(resolvers);
		return resolver;
	}

	/**
	 * Configure View resolver to provide XLS output using Apache POI library to
	 * generate XLS output for an object content
	 */
	@Bean
	public ViewResolver excelViewResolver() {
		return new ExcelViewResolver();
	}

	/**
	 * Configure View resolver to provide Csv output using Super Csv library to
	 * generate Csv output for an object content
	 */
	@Bean
	public ViewResolver csvViewResolver() {
		return new CsvViewResolver();
	}

	/**
	 * Configure View resolver to provide Pdf output using iText library to
	 * generate pdf output for an object content
	 */
	@Bean
	public ViewResolver pdfViewResolver() {
		return new PdfViewResolver();
	}


}
