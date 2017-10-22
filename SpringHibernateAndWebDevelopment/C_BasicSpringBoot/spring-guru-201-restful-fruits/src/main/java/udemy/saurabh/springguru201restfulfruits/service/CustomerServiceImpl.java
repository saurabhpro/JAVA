package udemy.saurabh.springguru201restfulfruits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.ICustomerMapper;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CustomerDTO;
import udemy.saurabh.springguru201restfulfruits.model.Customer;
import udemy.saurabh.springguru201restfulfruits.repository.ICustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {
	private ICustomerMapper customerMapper;

	private ICustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(ICustomerMapper customerMapper, ICustomerRepository customerRepository) {
		this.customerMapper = customerMapper;
		this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		return customerRepository.findAll()
				.stream()
				.map(customer -> {
					CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
					customerDTO.setCustomerUrl("/api/v1/customer/" + customer.getId());
					return customerDTO;
				})
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO getCustomerById(long id) {
		return customerMapper.customerToCustomerDTO(customerRepository.getOne(id));
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO newCustomerDTO) {
		Customer customer = customerMapper.customerDTOToCustomer(newCustomerDTO);

		Customer savedCustomer = customerRepository.save(customer);

		CustomerDTO retrievedCustomerDTP = customerMapper.customerToCustomerDTO(savedCustomer);
		retrievedCustomerDTP.setCustomerUrl("/api/v1/customer/" + savedCustomer.getId());

		return retrievedCustomerDTP;
	}
}
