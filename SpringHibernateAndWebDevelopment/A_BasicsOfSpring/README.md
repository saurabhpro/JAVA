
# Autowired Types
//TODO


# 1. with xml config

in application context. xml
```xml
<bean name="customerService"
          class="com.saurabh.service.CustomerServiceImpl"
          autowire="byType"
          scope="prototype"
    >
<bean name="customerRepository"
    class="com.saurabh.repository.HibernateCustomerRepositoryImpl">

    <property name="dbUserName" value="${dBUserName}"/>
</bean>
```

```java
//Old Mannual Method: CustomerService service = new CustomerServiceImpl();

//New : Step 1 - create context
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//maven put it to the root of app after compilation

//Step 2: Make Class
CustomerService service = applicationContext.getBean("customerService", CustomerService.class);
/* 
*/
//arg2 is there such that we dont have to cast the bean or suppress cast messages

System.out.println(service.findAll().get(0).getFirstName());
```

Service and Resposiotory should be in pattern `XXX[Service|ServiceImpl].java` or `XXX[Resposiotory|RepositoryImpl].java`
service is composed of Respository
```java
/**
* @param customerRepository
*/
@Autowired
public CustomerServiceImpl(CustomerRepository customerRepository) {
    System.out.println("We are using constructor injection");

    this.customerRepository = customerRepository;
}
```


# 2. with xml & java

Here the appContext need only these two essentials
```xml
<context:annotation-config/> <!--  -->

<context:component-scan base-package="com.saurabh"/>
```
and then use annotation in java impl classes
```java
@Service("customerService" /*bean name*/)
@Repository("customerRepository" /*bean name*/)
```java

and then in the main class

```java
//Old: CustomerService service = new CustomerServiceImpl();

//New : Step 1 - create context
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//maven put it to the root of app after compilation

//Step 2: Make Class
CustomerService service = applicationContext.getBean("customerService", CustomerService.class);
//arg2 is there such that we dont have to cast the bean or suppress cast messages

System.out.println(service.findAll().get(0).getFirstName());
```

# 3. all java

a sample appConfig.java
```java
//declare that it is a configuration file purely written in java
@Configuration

// For Autowire :
@ComponentScan({ /* array of packages to look in */ "com.saurabh"})
public class AppConfig {

	// ``````````````this whole block can be removed since we Annotated both
	// Repository and Service
	// --------------those special annotations internally make them into Bean only.

	@Bean(name = "customerRepository")
	public CustomerRepository getCustomerRepository() {
		return new HibernateCustomerRepositoryImpl();
		/*
		 * in the background spring handles these beans as singleton
		 */
	}

	@Bean(name = "customerService")
	public CustomerService getCustomerService() {
		/*
		 * another approach is to set using constructor as it will do the same thing, no
		 * need to write 2 lines to do one line job
		 */
		// CustomerServiceImpl service = new
		// CustomerServiceImpl(getCustomerRepository());

		CustomerServiceImpl service = new CustomerServiceImpl();
		/*
		 * setter injection is much more visible, that we first get the customer
		 * repository and then pass it to our service impl it's different from just
		 * calling setter, why ?
		 * 
		 * because as it is marked as bean, spring will now look at its context and
		 * check if that repository bean is created and inject that instance if it has
		 */
		// service.setCustomerRepository(getCustomerRepository());
		return service;
	}

	// `````````````````````````till here

}
```

For Properties we add
```java
@Bean
public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
    //it takes all items from properties file and the makes them into this object and make it available in context
}
```
to the above config class


and then the same old 

```java

// Old: CustomerService service = new CustomerServiceImpl();

// New : Step 1 - create context
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

// Step 2: Make Class
CustomerService service = applicationContext.getBean("customerService", CustomerService.class);
// arg2 is there such that we don't have to cast the bean or suppress cast
// messages

System.out.println(service.findAll().get(0).getFirstName());
```
