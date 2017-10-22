package udemy.saurabh.springguru201restfulfruits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.ICustomerMapper;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CustomerDTO;
import udemy.saurabh.springguru201restfulfruits.controller.v1.CustomerController;
import udemy.saurabh.springguru201restfulfruits.model.Customer;
import udemy.saurabh.springguru201restfulfruits.model.exceptions.ResourceNotFoundException;
import udemy.saurabh.springguru201restfulfruits.repository.ICustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {
	private final ICustomerMapper customerMapper;

	private final ICustomerRepository customerRepository;

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
					customerDTO.setCustomerUrl(getCustomerURL(customer.getId()));
					return customerDTO;
				})
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO getCustomerById(long id) {
		return customerRepository.findById(id)
				.map(customerMapper::customerToCustomerDTO)
				.map(customerDTO -> {
					//set API URL
					customerDTO.setCustomerUrl(getCustomerURL(id));
					return customerDTO;
				})
				.orElseThrow(ResourceNotFoundException::new);
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
		retrievedCustomerDTO.setCustomerUrl(getCustomerURL(savedCustomer.getId()));

		return retrievedCustomerDTO;
	}

	@Override
	public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
		return customerRepository
				.findById(id)
				.map(customer -> {
							if (customerDTO.getFirstName() != null) {
								customer.setFirstName(customerDTO.getFirstName());
							}

							if (customerDTO.getLastName() != null) {
								customer.setLastName(customerDTO.getLastName());
							}

							CustomerDTO returnDto = customerMapper.customerToCustomerDTO(customerRepository.save(customer));
							returnDto.setCustomerUrl(getCustomerURL(id));
							return returnDto;
						}
				)
				.orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteCustomer(Long id) {
		try {
			customerRepository.deleteById(id);
		} catch (EmptyResultDataAccessException exception) {
			throw new ResourceNotFoundException();
		}
	}


	String getCustomerURL(Long id) {
		return CustomerController.BASE_URL + "/" + id;
	}
}
