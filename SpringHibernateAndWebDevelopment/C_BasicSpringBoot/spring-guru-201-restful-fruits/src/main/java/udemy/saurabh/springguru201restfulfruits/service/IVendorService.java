package udemy.saurabh.springguru201restfulfruits.service;

import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorDTO;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorListDTO;

public interface IVendorService {
	VendorListDTO getAllVendors();

	VendorDTO getVendorById(Long id);

	VendorDTO createNewVendor(VendorDTO newVendorDTO);

	VendorDTO updateVendorByPutVendorDTO(Long id, VendorDTO vendorDTO);

	void deleteVendor(Long id);

	VendorDTO patchVendor(Long id, VendorDTO customerDTO);
}
