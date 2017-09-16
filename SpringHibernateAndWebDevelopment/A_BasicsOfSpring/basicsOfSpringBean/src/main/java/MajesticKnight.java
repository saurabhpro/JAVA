import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MajesticKnight
		implements Knight,
		BeanNameAware,
		BeanFactoryAware,
		ApplicationContextAware,
		InitializingBean,
		DisposableBean {
	private String knightName = "Majestic Knight";

	public String getKnightName() {
		return knightName;
	}

	public void setKnightName(String knightName) {
		this.knightName = knightName;
	}

	public void setBeanName(String name) {
		System.out.println("setBeanName");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setApplicationContext");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

	@PostConstruct
	public void init() {
		System.out.println("init");
	}

	public void destroy() throws Exception {
		System.out.println("destroy");
	}

	@PreDestroy
	public void destroyCustom() throws Exception {
		System.out.println("destroyCustom");
	}

}