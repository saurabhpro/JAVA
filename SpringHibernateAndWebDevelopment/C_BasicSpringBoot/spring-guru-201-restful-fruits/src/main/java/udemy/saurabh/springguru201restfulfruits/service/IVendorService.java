package udemy.saurabh.springguru201restfulfruits.service;

import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorsDTO;

import java.util.List;

public interface IVendorService {
	List<VendorsDTO> getAllVendors();

	VendorsDTO getVendorById(Long id);

	VendorsDTO createNewVendor(VendorsDTO newVendorsDTO);

	VendorsDTO updateVendorByPutVendorDTO(Long id, VendorsDTO vendorsDTO);

	void deleteVendor(Long id);

	VendorsDTO patchVendor(Long id, VendorsDTO customerDTO);
}
