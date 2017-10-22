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
		CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customerRepository.getOne(id));

		customerDTO.setCustomerUrl("/api/v1/customer/" + id);

		return customerDTO;
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO newCustomerDTO) {
		Customer customer = customerMapper.customerDTOToCustomer(newCustomerDTO);

		return saveAndReturnCustomerDTO(customer);
	}

	@Override
	public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {
		Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
		customer.setId(id);

		return saveAndReturnCustomerDTO(customer);
	}

	private CustomerDTO saveAndReturnCustomerDTO(Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);

		CustomerDTO retrievedCustomerDTO = customerMapper.customerToCustomerDTO(savedCustomer);
		retrievedCustomerDTO.setCustomerUrl("/api/v1/customer/" + savedCustomer.getId());

		return retrievedCustomerDTO;
	}
}
