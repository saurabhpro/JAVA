package udemy.saurabh.springguru201restfulfruits.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorDTO;
import udemy.saurabh.springguru201restfulfruits.model.Vendor;

@Mapper
public interface IVendorMapper {
	IVendorMapper INSTANCE = Mappers.getMapper(IVendorMapper.class);

	VendorDTO vendorToVendorDTO(Vendor vendor);

	Vendor vendorDtoToVendor(VendorDTO newVendorDTO);
}