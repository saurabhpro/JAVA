package udemy.saurabh.springguru201restfulfruits.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorsDTO;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorsListDTO;
import udemy.saurabh.springguru201restfulfruits.service.IVendorService;

import static udemy.saurabh.springguru201restfulfruits.controller.v1.VendorController.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
public class VendorController {
	static final String BASE_URL = "/api/v1/vendors";

	private IVendorService vendorService;

	@Autowired
	public VendorController(IVendorService vendorService) {
		this.vendorService = vendorService;
	}

	@GetMapping
	VendorsListDTO getAllCustomers() {
		return new VendorsListDTO(vendorService.getAllVendors());
	}

	@GetMapping("/{id}") // by default sends HttpStatus.OK
	public VendorsDTO getCustomerById(@PathVariable Long id) {
		return vendorService.getVendorById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VendorsDTO createNewCustomer(@RequestBody VendorsDTO customerDTO) {
		return vendorService.createNewVendor(customerDTO);
	}

	@PutMapping("/{id}") // by default sends HttpStatus.OK
	public VendorsDTO updateCustomerById(@RequestBody VendorsDTO customerDTO, @PathVariable Long id) {
		return vendorService.updateVendorByPutVendorDTO(id, customerDTO);
	}

	@PatchMapping({"/{id}"})
	public VendorsDTO patchCustomer(@PathVariable Long id, @RequestBody VendorsDTO customerDTO) {
		return vendorService.patchVendor(id, customerDTO);
	}

	@DeleteMapping({"/{id}"})
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		vendorService.deleteVendor(id);

		return new ResponseEntity<>(HttpStatus.OK); // just for knowledge of whats happening
	}
}
