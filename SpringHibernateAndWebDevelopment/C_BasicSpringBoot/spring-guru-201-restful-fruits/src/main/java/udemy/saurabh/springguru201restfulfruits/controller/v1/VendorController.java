package udemy.saurabh.springguru201restfulfruits.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorDTO;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorListDTO;
import udemy.saurabh.springguru201restfulfruits.service.IVendorService;

import static udemy.saurabh.springguru201restfulfruits.controller.v1.VendorController.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
public class VendorController {
	static final String BASE_URL = "/api/v1/vendors";

	private final IVendorService vendorService;

	@Autowired
	public VendorController(IVendorService vendorService) {
		this.vendorService = vendorService;
	}

	@GetMapping
	VendorListDTO getAllCustomers() {
		return vendorService.getAllVendors();
	}

	@GetMapping("/{id}") // by default sends HttpStatus.OK
	public VendorDTO getCustomerById(@PathVariable Long id) {
		return vendorService.getVendorById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VendorDTO createNewCustomer(@RequestBody VendorDTO customerDTO) {
		return vendorService.createNewVendor(customerDTO);
	}

	@PutMapping("/{id}") // by default sends HttpStatus.OK
	public VendorDTO updateCustomerById(@RequestBody VendorDTO customerDTO, @PathVariable Long id) {
		return vendorService.updateVendorByPutVendorDTO(id, customerDTO);
	}

	@PatchMapping({"/{id}"})
	public VendorDTO patchCustomer(@PathVariable Long id, @RequestBody VendorDTO customerDTO) {
		return vendorService.patchVendor(id, customerDTO);
	}

	@DeleteMapping({"/{id}"})
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		vendorService.deleteVendor(id);

		return new ResponseEntity<>(HttpStatus.OK); // just for knowledge of whats happening
	}
}
