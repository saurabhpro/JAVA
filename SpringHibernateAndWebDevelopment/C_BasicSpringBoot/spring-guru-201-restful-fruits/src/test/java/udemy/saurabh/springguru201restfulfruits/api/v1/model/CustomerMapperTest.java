package udemy.saurabh.springguru201restfulfruits.api.v1.model;

import org.junit.Test;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.ICustomerMapper;
import udemy.saurabh.springguru201restfulfruits.model.Customer;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {

	public static final String FIRSTNAME = "Jimmy";
	public static final String LASTNAME = "Fallon";
	ICustomerMapper customerMapper = ICustomerMapper.INSTANCE;

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