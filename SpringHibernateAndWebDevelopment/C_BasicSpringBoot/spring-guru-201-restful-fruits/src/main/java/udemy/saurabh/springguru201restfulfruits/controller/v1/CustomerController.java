package udemy.saurabh.springguru201restfulfruits.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CustomerDTO;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CustomerListDTO;
import udemy.saurabh.springguru201restfulfruits.service.ICustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private ICustomerService customerService;

	@Autowired
	public CustomerController(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	CustomerListDTO getAllCustomers() {
		return new CustomerListDTO(customerService.getAllCustomers());
	}

	@GetMapping("/{id}") // by default sends HttpStatus.OK
	public CustomerDTO getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}

	@PostMapping
	public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO) {
		return new ResponseEntity<>(customerService.createNewCustomer(customerDTO), HttpStatus.CREATED);
	}

	@PutMapping("/{id}") // by default sends HttpStatus.OK
	public CustomerDTO updateCustomerById(@RequestBody CustomerDTO customerDTO, @PathVariable Long id) {
		return customerService.saveCustomerByDTO(id, customerDTO);
	}
}
