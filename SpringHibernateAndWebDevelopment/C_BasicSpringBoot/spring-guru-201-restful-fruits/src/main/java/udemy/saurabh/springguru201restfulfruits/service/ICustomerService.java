package udemy.saurabh.springguru201restfulfruits.service;

import udemy.saurabh.springguru201restfulfruits.api.v1.model.CustomerDTO;

import java.util.List;

public interface ICustomerService {
	List<CustomerDTO> getAllCustomers();

	//void deleteCustomerByFirstName(String s);

	CustomerDTO getCustomerById(long id);

	CustomerDTO createNewCustomer(CustomerDTO newCustomerDTO);

	CustomerDTO updateCustomerByPutCustomerDTO(Long id, CustomerDTO customer);

	CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

	void deleteCustomer(Long id);

}
