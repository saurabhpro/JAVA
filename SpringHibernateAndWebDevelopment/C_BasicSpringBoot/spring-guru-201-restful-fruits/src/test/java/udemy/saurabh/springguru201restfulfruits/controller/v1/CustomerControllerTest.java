package udemy.saurabh.springguru201restfulfruits.controller.v1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CustomerDTO;
import udemy.saurabh.springguru201restfulfruits.service.ICustomerService;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static udemy.saurabh.springguru201restfulfruits.controller.v1.AbstractRestControllerTest.asJsonString;

public class CustomerControllerTest {
	private static final String FIRST_NAME = "Saurabh";
	private static final String LAST_NAME = "Kumar";

	@Mock
	private
	ICustomerService customerService;

	@InjectMocks
	private    // inject @Mock to this controller, so no need to do controller = new Contoller(service)
			CustomerController customerController;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void testGetAllCustomers() throws Exception {
		//given
		CustomerDTO customer1 = new CustomerDTO();
		customer1.setFirstName("Michale");
		customer1.setLastName("Weston");
		customer1.setCustomerUrl("/api/v1/customer/1");

		CustomerDTO customer2 = new CustomerDTO();
		customer2.setFirstName("Sam");
		customer2.setFirstName("Axe");
		customer2.setCustomerUrl("/api/v1/customer/2");

		when(customerService.getAllCustomers()).thenReturn(Arrays.asList(customer1, customer2));

		mockMvc.perform(get("/api/v1/customers/")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.customers", hasSize(2)));
	}

	@Test
	public void testGetCustomerById() throws Exception {

		//given
		CustomerDTO customer1 = new CustomerDTO();
		customer1.setFirstName("Michale");
		customer1.setLastName("Weston");
		customer1.setCustomerUrl("/api/v1/customer/1");

		when(customerService.getCustomerById(anyLong())).thenReturn(customer1);

		//when
		mockMvc.perform(get("/api/v1/customers/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", equalTo("Michale")));
	}

	@Test
	public void createNewCustomer() throws Exception {
		//given
		CustomerDTO customer = new CustomerDTO();
		customer.setFirstName("Fred");
		customer.setLastName("Flintstone");

		CustomerDTO returnDTO = new CustomerDTO();
		returnDTO.setFirstName(customer.getFirstName());
		returnDTO.setLastName(customer.getLastName());
		returnDTO.setCustomerUrl("/api/v1/customers/1");

		when(customerService.createNewCustomer(customer)).thenReturn(returnDTO);

		//when/then
		mockMvc.perform(post("/api/v1/customers/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(customer)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.firstName", equalTo("Fred")))
				.andExpect(jsonPath("$.customer_url", equalTo("/api/v1/customers/1"))); // from jsonProperty
	}


	@Test
	public void testDeleteByCustomerFirstName() throws Exception {

	}
}