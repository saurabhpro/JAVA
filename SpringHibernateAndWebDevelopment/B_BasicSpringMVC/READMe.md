```java
@Controller
@RequestMapping("/appointments")    //indicates that all handler methods in this controller are relative to the /appointments path. 
public class AppointmentsController {

    private final AppointmentBook appointmentBook;

    @Autowired
    public AppointmentsController(AppointmentBook appointmentBook) {
        this.appointmentBook = appointmentBook;
    }

    @GetMapping
    public Map<String, Appointment> get() {
        return appointmentBook.getAppointmentsForToday();
    }

    @GetMapping("/{day}")
    public Map<String, Appointment> getForDay(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day, Model model) {
        return appointmentBook.getAppointmentsForDay(day);
    }

    @GetMapping("/new")
    public AppointmentForm getNewForm() {
        return new AppointmentForm();
    }

    @PostMapping
    public String add(@Valid AppointmentForm appointment, BindingResult result) {
        if (result.hasErrors()) {
            return "appointments/new";
        }
        appointmentBook.addAppointment(appointment);
        return "redirect:/appointments";
    }
}
```


## Composed @RequestMapping Variants
Spring Framework 4.3 introduces the following method-level composed variants of the @RequestMapping annotation that help to simplify mappings for common HTTP methods and better express the semantics of the annotated handler method. For example, a @GetMapping can be read as a GET @RequestMapping.

- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- @PatchMapping


## URI Template Patterns

URI templates can be used for convenient access to selected parts of a URL in a @RequestMapping method.

In Spring MVC you can use the @PathVariable annotation on a method argument to bind it to the value of a URI template variable:
```java
@GetMapping("/owners/{ownerId}")
public String findOwner(@PathVariable String ownerId, Model model) {
    /*The URI Template " /owners/{ownerId}`" specifies the variable name `ownerId. When the controller handles this request, the value of ownerId is set to the value found in the appropriate part of the URI. 
    
    For example, when a request comes in for /owners/fred, the value of ownerId is fred.*/

    Owner owner = ownerService.findOwner(ownerId);
    model.addAttribute("owner", owner);
    return "displayOwner";
}

/*To process the @PathVariable annotation, Spring MVC needs to find the matching URI template variable by name. You can specify it in the annotation:*/
@GetMapping("/owners/{ownerId}")
public String findOwner(@PathVariable("ownerId") String theOwner, Model model) {
    // implementation omitted
}

/*Or if the URI template variable name matches the method argument name you can omit that detail. (java 8)*/
@GetMapping("/owners/{ownerId}")
public String findOwner(@PathVariable String ownerId, Model model) {
    // implementation omitted
}
```

## Suffix Pattern Matching

By default Spring MVC performs ".*" suffix pattern matching so that a controller mapped to /person is also implicitly mapped to /person.*. This makes it easy to request different representations of a resource through the URL path (e.g. /person.pdf, /person.xml).

## Consumable Media Types

You can narrow the primary mapping by specifying a list of consumable media types. The request will be matched only if the Content-Type request header matches the specified media type. For example:
```java
@PostMapping(path = "/pets", consumes = "application/json")
public void addPet(@RequestBody Pet pet, Model model) {
    // implementation omitted
}
```
Consumable media type expressions can also be negated as in `!text/plain` to match to all requests other than those with Content-Type of text/plain.

## Producible Media Types

You can narrow the primary mapping by specifying a list of producible media types. The request will be matched only if the Accept request header matches one of these values. Furthermore, use of the produces condition ensures the actual content type used to generate the response respects the media types specified in the produces condition. For example:
```java
@GetMapping(path = "/pets/{petId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ResponseBody
public Pet getPet(@PathVariable String petId, Model model) {
    // implementation omitted
}
```

## HTTP HEAD and HTTP OPTIONS

@RequestMapping methods mapped to "GET" are also implicitly mapped to "HEAD", i.e. there is no need to have "HEAD" explicitly declared. An HTTP HEAD request is processed as if it were an HTTP GET except instead of writing the body only the number of bytes are counted and the "Content-Length" header set.

@RequestMapping methods have built-in support for HTTP OPTIONS. By default an HTTP OPTIONS request is handled by setting the "Allow" response header to the HTTP methods explicitly declared on all @RequestMapping methods with matching URL patterns. When no HTTP methods are explicitly declared the "Allow" header is set to "GET,HEAD,POST,PUT,PATCH,DELETE,OPTIONS". Ideally always declare the HTTP method(s) that an @RequestMapping method is intended to handle.

## https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-methods

The `Errors` or `BindingResult` parameters have to follow the model object that is being bound immediately as the method signature might have more than one model object and Spring will create a separate BindingResult instance for each of them so the following sample won’t work:

__Invalid ordering of BindingResult and @ModelAttribute.__
```java
@PostMapping
public String processSubmit(@ModelAttribute("pet") Pet pet, Model model, BindingResult result) { ... }
```
Note, that there is a Model parameter in between Pet and BindingResult. To get this working you have to reorder the parameters as follows:
```java
@PostMapping
public String processSubmit(@ModelAttribute("pet") Pet pet, BindingResult result, Model model) { ... }
```
[Note]
`JDK 1.8’s java.util.Optional is supported as a method parameter type with annotations that have a required attribute (e.g. @RequestParam, @RequestHeader, etc. The use of java.util.Optional in those cases is equivalent to having required=false.`


The @ResponseBody annotation is similar to @RequestBody. 
This annotation can be placed on a method and indicates that the return type should be written straight to the HTTP response body (and not placed in a Model, or interpreted as a view name). 

This is what @RestController imply

## Using @ModelAttribute on a methods
@ModelAttribute methods are used to populate the model with commonly needed attributes for example to fill a drop-down with states or with pet types, or to retrieve a command object like Account in order to use it to represent the data on an HTML form. The latter case is further discussed in the next section.

// Add one attribute
// The return value of the method is added to the model under the name "account"
// You can customize the name via @ModelAttribute("myAccount")
```java
@ModelAttribute //if the method returns an object of type Account, the default name used is "account". 
public Account addAccount(@RequestParam String number) {
    return accountManager.findAccount(number);
}

// Add multiple attributes
@ModelAttribute
public void populateModel(@RequestParam String number, Model model) {
    model.addAttribute(accountManager.findAccount(number));
    // add more ...
}
```
In the first, the method adds an attribute implicitly by returning it. In the second, the method accepts a Model and adds any number of model attributes to it. You can choose between the two styles depending on your needs.

## Using @ModelAttribute on a method argument

As explained in the previous section @ModelAttribute can be used on methods or on method arguments. This section explains its usage on method arguments.

An @ModelAttribute on a method argument indicates the argument should be retrieved from the model. If not present in the model, the argument should be instantiated first and then added to the model. Once present in the model, the argument’s fields should be populated from all request parameters that have matching names. This is known as data binding in Spring MVC, a very useful mechanism that saves you from having to parse each form field individually.
```java
@PutMapping("/accounts/{account}")
public String save(@ModelAttribute("account") Account account) {
    // ...
}
```
the name of the model attribute (i.e. "account") matches the name of a URI template variable. 
The next step is data binding. The WebDataBinder class matches request parameter names — including query string parameters and form fields — to model attribute fields by name. Matching fields are populated after type conversion (from String to the target field type) has been applied where necessary. 

As a result of data binding there may be errors such as missing required fields or type conversion errors. To check for such errors add a BindingResult argument immediately following the @ModelAttribute argument:

You can have validation invoked automatically by adding the JSR-303 @Valid annotation:
allows for data binding and validation errors to be accumulated in one place and subsequently reported back to the user:
```java
@PostMapping("/owners/{ownerId}/pets/{petId}/edit")
public String processSubmit(@Valid @ModelAttribute("pet") Pet pet, BindingResult result) {

    if (result.hasErrors()) {
        return "petForm";
    }

    // ...

}
```
With a BindingResult you can check if errors were found in which case it’s common to render the same form where the errors can be shown with the help of Spring’s <errors> form tag.

Note that in some cases it may be useful to gain access to an attribute in the model without data binding. For such cases you may inject the Model into the controller or alternatively use the binding flag on the annotation:

Using @SessionAttributes to store model attributes in the HTTP session between requests

The type-level @SessionAttributes annotation declares session attributes used by a specific handler. This will typically list the names of model attributes or types of model attributes which should be transparently stored in the session or some conversational storage, serving as form-backing beans between subsequent requests.

@SessionAttributes("pet")
public class EditPetForm {
    // ...
}

Using @SessionAttribute to access pre-existing global session attributes

If you need access to pre-existing session attributes that are managed globally, i.e. outside the controller (e.g. by a filter), and may or may not be present use the @SessionAttribute annotation on a method parameter:

@RequestMapping("/")
public String handle(@SessionAttribute User user) {
    // ...
}

Using @RequestAttribute to access request attributes

Similar to @SessionAttribute the @RequestAttribute annotation can be used to access pre-existing request attributes created by a filter or interceptor:

@RequestMapping("/")
public String handle(@RequestAttribute Client client) {
    // ...
}

Mapping cookie values with the @CookieValue annotation

The @CookieValue annotation allows a method parameter to be bound to the value of an HTTP cookie.

Let us consider that the following cookie has been received with an http request:

JSESSIONID=415A4AC178C59DACE0B2C9CA727CDD84
The following code sample demonstrates how to get the value of the JSESSIONID cookie:

@RequestMapping("/displayHeaderInfo.do")
public void displayHeaderInfo(@CookieValue("JSESSIONID") String cookie) {
    //...
}

Mapping request header attributes with the @RequestHeader annotation

The @RequestHeader annotation allows a method parameter to be bound to a request header.

Here is a sample request header:

Host                    localhost:8080
Accept                  text/html,application/xhtml+xml,application/xml;q=0.9
Accept-Language         fr,en-gb;q=0.7,en;q=0.3
Accept-Encoding         gzip,deflate
Accept-Charset          ISO-8859-1,utf-8;q=0.7,*;q=0.7
Keep-Alive              300
The following code sample demonstrates how to get the value of the Accept-Encoding and Keep-Alive headers:

@RequestMapping("/displayHeaderInfo.do")
public void displayHeaderInfo(@RequestHeader("Accept-Encoding") String encoding,
        @RequestHeader("Keep-Alive") long keepAlive) {
    //...
}
Type conversion is applied automatically if the method parameter is not String. See the section called “Method Parameters And Type Conversion”.

**When an @RequestHeader annotation is used on a Map<String, String>, MultiValueMap<String, String>, or HttpHeaders argument, the map is populated with all header values.**