package udemy.saurabh.springguru201restfulfruits.api.v1.model;

import org.junit.Test;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.ICustomerMapper;
import udemy.saurabh.springguru201restfulfruits.model.Customer;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {

	private static final String FIRSTNAME = "Jimmy";
	private static final String LASTNAME = "Fallon";
	private final ICustomerMapper customerMapper = ICustomerMapper.INSTANCE;

	@Test
	public void customerToCustomerDTO() throws Exception {
		//given
		Customer customer = new Customer();
		customer.setFirstName(FIRSTNAME);
		customer.setLastName(LASTNAME);

		//when
		CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

		//then
		assertEquals(FIRSTNAME, customerDTO.getFirstName());
		assertEquals(LASTNAME, customerDTO.getLastName());

	}
}