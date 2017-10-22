package udemy.saurabh.springguru201restfulfruits.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.IVendorMapper;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorsDTO;
import udemy.saurabh.springguru201restfulfruits.model.Vendor;
import udemy.saurabh.springguru201restfulfruits.repository.IVendorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class VendorServiceTest {

	@Mock
	private IVendorRepository vendorRepository;

	private IVendorService vendorService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		vendorService = new VendorServiceImpl(IVendorMapper.INSTANCE, vendorRepository);
	}

	@Test
	public void getAllVendors() throws Exception {
		//given
		List<Vendor> vendors = Arrays.asList(new Vendor(), new Vendor(), new Vendor());

		when(vendorRepository.findAll()).thenReturn(vendors);

		//when
		List<VendorsDTO> vendorsDTOS = vendorService.getAllVendors();

		//then
		assertEquals(3, vendorsDTOS.size());
	}

	@Test
	public void getCustomerById() throws Exception {
		//given
		Vendor vendor = new Vendor();
		vendor.setId(1L);
		vendor.setName("Aaloo");
		when(vendorRepository.findById(anyLong())).thenReturn(Optional.of(vendor));

		//when
		VendorsDTO vendorsDTO = vendorService.getVendorById(1L);

		assertEquals("Aaloo", vendorsDTO.getName());
	}

	@Test
	public void createNewCustomer() throws Exception {

		//given
		VendorsDTO vendorsDTO = new VendorsDTO();
		vendorsDTO.setName("Aaloo");

		Vendor savedVendor = new Vendor();
		savedVendor.setName(vendorsDTO.getName());
		savedVendor.setId(1L);

		when(vendorRepository.save(any(Vendor.class))).thenReturn(savedVendor);

		//when
		VendorsDTO savedDto = vendorService.createNewVendor(vendorsDTO);

		//then
		assertEquals(vendorsDTO.getName(), savedDto.getName());
		assertEquals("api/v1/vendors/1", savedDto.getVendorUrl());
	}

	@Test
	public void updateVendorByPutVendorDTO() throws Exception {

		//given
		VendorsDTO vendorsDTO = new VendorsDTO();
		vendorsDTO.setName("Aaloo");

		Vendor savedVendor = new Vendor();
		savedVendor.setName(vendorsDTO.getName());
		savedVendor.setId(1L);

		when(vendorRepository.save(any(Vendor.class))).thenReturn(savedVendor);

		//when
		VendorsDTO savedDto = vendorService.updateVendorByPutVendorDTO(1L, vendorsDTO);

		//then
		assertEquals(vendorsDTO.getName(), savedDto.getName());
		assertEquals("api/v1/vendors/1", savedDto.getVendorUrl());
	}

	@Test
	public void testDeleteCustomerById() {
		//when
		Long id = 1L;

		vendorService.deleteVendor(id);

		verify(vendorRepository, times(1)).deleteById(anyLong());
	}

	@Test
	public void testGetCustomURL() {
		VendorServiceImpl cs = new VendorServiceImpl(IVendorMapper.INSTANCE, vendorRepository);
		assertEquals("api/v1/vendors/1", cs.getCustomerURL(1L));
	}
}