package udemy.saurabh.springguru201restfulfruits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.IVendorMapper;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorsDTO;
import udemy.saurabh.springguru201restfulfruits.model.Vendor;
import udemy.saurabh.springguru201restfulfruits.model.exceptions.ResourceNotFoundException;
import udemy.saurabh.springguru201restfulfruits.repository.IVendorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements IVendorService {

	private IVendorMapper vendorMapper;
	private IVendorRepository vendorRepository;

	@Autowired
	public VendorServiceImpl(IVendorMapper vendorMapper, IVendorRepository vendorRepository) {
		this.vendorMapper = vendorMapper;
		this.vendorRepository = vendorRepository;
	}

	String getCustomerURL(Long id) {
		return "api/v1/vendors/" + id;
	}

	@Override
	public List<VendorsDTO> getAllVendors() {
		return vendorRepository.findAll().stream()
				.map(vendor -> {
					VendorsDTO vendorsDTO = vendorMapper.vendorToVendorDTO(vendor);
					vendorsDTO.setVendorUrl(getCustomerURL(vendor.getId()));
					return vendorsDTO;
				}).collect(Collectors.toList());
	}

	@Override
	public VendorsDTO getVendorById(Long id) {
		return vendorRepository.findById(id)
				.map(vendor -> {
					VendorsDTO vendorsDTO = vendorMapper.vendorToVendorDTO(vendor);
					vendorsDTO.setVendorUrl(getCustomerURL(id));
					return vendorsDTO;
				}).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public VendorsDTO createNewVendor(VendorsDTO newVendorsDTO) {
		Vendor vendor = vendorMapper.vendorDtoToVendor(newVendorsDTO);

		return saveAndReturnVendorsDTO(vendor);
	}

	private VendorsDTO saveAndReturnVendorsDTO(Vendor vendor) {
		Vendor savedVendor = vendorRepository.save(vendor);
		VendorsDTO retrievedVendorDto = vendorMapper.vendorToVendorDTO(savedVendor);
		retrievedVendorDto.setVendorUrl("api/v1/vendors/" + savedVendor.getId());

		return retrievedVendorDto;
	}

	@Override
	public VendorsDTO updateVendorByPutVendorDTO(Long id, VendorsDTO vendorsDTO) {
		Vendor vendor = vendorMapper.vendorDtoToVendor(vendorsDTO);
		vendor.setId(id);

		return saveAndReturnVendorsDTO(vendor);
	}

	@Override
	public void deleteVendor(Long id) {
		try {
			vendorRepository.deleteById(id);
		} catch (Exception ex) {
			throw new ResourceNotFoundException();
		}
	}
}