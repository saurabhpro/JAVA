package udemy.saurabh.springguru201restfulfruits.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.ICustomerMapper;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CustomerDTO;
import udemy.saurabh.springguru201restfulfruits.model.Customer;
import udemy.saurabh.springguru201restfulfruits.repository.ICustomerRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

	public static final long ID = 22L;
	public static final String FIRST_NAME = "Saurabh";
	public static final String LAST_NAME = "Kumar";

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
		customer1.setId(1L);
		customer1.setFirstName("Michale");
		customer1.setLastName("Weston");

		when(customerRepository.getOne(anyLong())).thenReturn(customer1);

		//when
		CustomerDTO customerDTO = customerService.getCustomerById(1L);

		assertEquals("Michale", customerDTO.getFirstName());
	}

	@Test
	public void createNewCustomer() throws Exception {

		//given
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstName("Jim");

		Customer savedCustomer = new Customer();
		savedCustomer.setFirstName(customerDTO.getFirstName());
		savedCustomer.setLastName(customerDTO.getLastName());
		savedCustomer.setId(1L);

		when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

		//when
		CustomerDTO savedDto = customerService.createNewCustomer(customerDTO);

		//then
		assertEquals(customerDTO.getFirstName(), savedDto.getFirstName());
		assertEquals("/api/v1/customer/1", savedDto.getCustomerUrl());
	}

	@Test
	public void saveCustomerByDTO() throws Exception {

		//given
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstName("Jim");

		Customer savedCustomer = new Customer();
		savedCustomer.setFirstName(customerDTO.getFirstName());
		savedCustomer.setLastName(customerDTO.getLastName());
		savedCustomer.setId(1L);

		when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

		//when
		CustomerDTO savedDto = customerService.saveCustomerByDTO(1L, customerDTO);

		//then
		assertEquals(customerDTO.getFirstName(), savedDto.getFirstName());
		assertEquals("/api/v1/customer/1", savedDto.getCustomerUrl());
	}
}