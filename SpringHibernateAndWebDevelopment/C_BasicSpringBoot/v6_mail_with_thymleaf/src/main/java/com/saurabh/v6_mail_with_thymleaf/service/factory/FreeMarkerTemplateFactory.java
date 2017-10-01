package com.saurabh.v6_mail_with_thymleaf.service.factory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by saurabhkumar on 15/09/17.
 */
@Component
public class FreeMarkerTemplateFactory {
	private static Configuration freemarkerConfiguration;

	@Autowired
	public FreeMarkerTemplateFactory(@Qualifier("freeMarkerConfiguration") Configuration freemarkerConfiguration) {
		FreeMarkerTemplateFactory.freemarkerConfiguration = freemarkerConfiguration;
	}

	public static String geFreeMarkerTemplateContent(Map<String, Object> model) throws IOException, TemplateException {

		// set loading location to src/main/resources
		// You may want to use a subfolder such as /templates here
		freemarkerConfiguration.setClassForTemplateLoading(FreeMarkerTemplateFactory.class, "/templates");

		Template t = freemarkerConfiguration.getTemplate("/fm_mailTemplate.ftl");

		return FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

	}

}
