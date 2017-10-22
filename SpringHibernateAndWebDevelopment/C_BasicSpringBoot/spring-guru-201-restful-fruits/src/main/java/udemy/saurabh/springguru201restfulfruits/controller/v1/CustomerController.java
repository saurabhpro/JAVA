package udemy.saurabh.springguru201restfulfruits.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CustomerDTO;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CustomerListDTO;
import udemy.saurabh.springguru201restfulfruits.service.ICustomerService;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

	public static final String BASE_URL = "/api/v1/customers";

	private final ICustomerService customerService;

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

//	@PostMapping
//	public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO) {
//		return new ResponseEntity<>(customerService.createNewCustomer(customerDTO), HttpStatus.CREATED);
//	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO) {
		return customerService.createNewCustomer(customerDTO);
	}

	@PutMapping("/{id}") // by default sends HttpStatus.OK
	public CustomerDTO updateCustomerById(@RequestBody CustomerDTO customerDTO, @PathVariable Long id) {
		return customerService.updateCustomerByPutCustomerDTO(id, customerDTO);
	}

	@PatchMapping({"/{id}"})
	public CustomerDTO patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
		return customerService.patchCustomer(id, customerDTO);
	}

	@DeleteMapping({"/{id}"})
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);

		return new ResponseEntity<>(HttpStatus.OK); // just for knowledge of whats happening
	}
}
