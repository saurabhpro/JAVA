package udemy.saurabh.springguru201restfulfruits.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.ICustomerMapper;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CustomerDTO;
import udemy.saurabh.springguru201restfulfruits.controller.v1.CustomerController;
import udemy.saurabh.springguru201restfulfruits.model.Customer;
import udemy.saurabh.springguru201restfulfruits.repository.ICustomerRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

	private static final long ID = 1L;
	private static final String FIRST_NAME = "Saurabh";
	private static final String API_V1_CUSTOMER_1 = CustomerController.BASE_URL + "/1";

	@Mock
	private ICustomerRepository customerRepository;

	private ICustomerService customerService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		customerService = new CustomerServiceImpl(ICustomerMapper.INSTANCE, customerRepository);
	}

	@Test
	public void getAllCustomers() throws Exception {
		//given
		List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

		when(customerRepository.findAll()).thenReturn(customers);

		//when
		List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

		//then
		assertEquals(3, customerDTOS.size());
	}

	@Test
	public void getCustomerById() throws Exception {
		//given
		Customer customer1 = new Customer();
		customer1.setId(ID);
		customer1.setFirstName(FIRST_NAME);
		customer1.setLastName("Weston");

		when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer1));

		//when
		CustomerDTO customerDTO = customerService.getCustomerById(1L);

		assertEquals(FIRST_NAME, customerDTO.getFirstName());
	}

	@Test
	public void createNewCustomer() throws Exception {

		//given
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstName(FIRST_NAME);

		Customer savedCustomer = new Customer();
		savedCustomer.setFirstName(customerDTO.getFirstName());
		savedCustomer.setLastName(customerDTO.getLastName());
		savedCustomer.setId(ID);

		when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

		//when
		CustomerDTO savedDto = customerService.createNewCustomer(customerDTO);

		//then
		assertEquals(customerDTO.getFirstName(), savedDto.getFirstName());
		assertEquals(API_V1_CUSTOMER_1, savedDto.getCustomerUrl());
	}

	@Test
	public void updateCustomerByPutCustomerDTO() throws Exception {

		//given
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstName(FIRST_NAME);

		Customer savedCustomer = new Customer();
		savedCustomer.setFirstName(customerDTO.getFirstName());
		savedCustomer.setLastName(customerDTO.getLastName());
		savedCustomer.setId(ID);

		when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

		//when
		CustomerDTO savedDto = customerService.updateCustomerByPutCustomerDTO(ID, customerDTO);

		//then
		assertEquals(customerDTO.getFirstName(), savedDto.getFirstName());
		assertEquals(API_V1_CUSTOMER_1, savedDto.getCustomerUrl());
	}

	@Test
	public void testDeleteCustomerById() {
		//when
		Long id = ID;

		customerService.deleteCustomer(id);

		verify(customerRepository, times(1)).deleteById(anyLong());
	}

	@Test
	public void testGetCustomURL() {
		CustomerServiceImpl cs = new CustomerServiceImpl(ICustomerMapper.INSTANCE, customerRepository);
		assertEquals(API_V1_CUSTOMER_1, cs.getCustomerURL(1L));
	}
}