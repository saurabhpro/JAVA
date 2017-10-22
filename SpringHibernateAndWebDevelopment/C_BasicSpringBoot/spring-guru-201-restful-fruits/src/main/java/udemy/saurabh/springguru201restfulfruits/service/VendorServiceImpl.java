package udemy.saurabh.springguru201restfulfruits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.IVendorMapper;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorDTO;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorListDTO;
import udemy.saurabh.springguru201restfulfruits.model.Vendor;
import udemy.saurabh.springguru201restfulfruits.model.exceptions.ResourceNotFoundException;
import udemy.saurabh.springguru201restfulfruits.repository.IVendorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements IVendorService {

	private final IVendorMapper vendorMapper;
	private final IVendorRepository vendorRepository;

	@Autowired
	public VendorServiceImpl(IVendorMapper vendorMapper, IVendorRepository vendorRepository) {
		this.vendorMapper = vendorMapper;
		this.vendorRepository = vendorRepository;
	}

	private String getCustomerURL(Long id) {
		return "api/v1/vendors/" + id;
	}

	@Override
	public VendorListDTO getAllVendors() {
		List<VendorDTO> list = vendorRepository.findAll().stream()
				.map(vendor -> {
					VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
					vendorDTO.setVendorUrl(getCustomerURL(vendor.getId()));
					return vendorDTO;
				}).collect(Collectors.toList());

		return new VendorListDTO(list);
	}

	@Override
	public VendorDTO getVendorById(Long id) {
		return vendorRepository.findById(id)
				.map(vendor -> {
					VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
					vendorDTO.setVendorUrl(getCustomerURL(id));
					return vendorDTO;
				}).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public VendorDTO createNewVendor(VendorDTO newVendorDTO) {
		Vendor vendor = vendorMapper.vendorDtoToVendor(newVendorDTO);

		return saveAndReturnVendorsDTO(vendor);
	}

	private VendorDTO saveAndReturnVendorsDTO(Vendor vendor) {
		Vendor savedVendor = vendorRepository.save(vendor);
		VendorDTO retrievedVendorDto = vendorMapper.vendorToVendorDTO(savedVendor);

		retrievedVendorDto.setVendorUrl("api/v1/vendors/" + savedVendor.getId());

		return retrievedVendorDto;
	}

	@Override
	public VendorDTO updateVendorByPutVendorDTO(Long id, VendorDTO vendorDTO) {
		Vendor vendor = vendorMapper.vendorDtoToVendor(vendorDTO);
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

	@Override
	public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
		return vendorRepository.findById(id)
				.map(vendor -> {
					//todo if more properties, add more if statements

					if (vendorDTO.getName() != null) {
						vendor.setName(vendorDTO.getName());
					}

					return saveAndReturnVendorsDTO(vendor);
				}).orElseThrow(ResourceNotFoundException::new);
	}

}