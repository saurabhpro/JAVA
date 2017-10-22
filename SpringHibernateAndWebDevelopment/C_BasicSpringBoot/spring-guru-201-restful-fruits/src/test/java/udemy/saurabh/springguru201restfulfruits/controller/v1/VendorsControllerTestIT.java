package udemy.saurabh.springguru201restfulfruits.controller.v1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorDTO;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorListDTO;
import udemy.saurabh.springguru201restfulfruits.model.exceptions.ResourceNotFoundException;
import udemy.saurabh.springguru201restfulfruits.service.IVendorService;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static udemy.saurabh.springguru201restfulfruits.controller.v1.AbstractRestControllerTest.asJsonString;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {VendorController.class})
public class VendorsControllerTestIT {

	//@Mock
	@MockBean //provided by Spring Context
	private IVendorService vendorService;

//	@InjectMocks
//	private    // inject @Mock to this controller, so no need to do controller = new Contoller(service)
//			VendorController vendorController;

	@Autowired
	private MockMvc mockMvc;

//	@Before
//	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//
//		mockMvc = MockMvcBuilders.standaloneSetup(vendorController)
//				.setControllerAdvice(new RestResponseEntityExceptionHandler())
//				.build();
//	}

	private VendorDTO vendorDTO_1;
	private VendorDTO vendorDTO_2;

	@Before
	public void setUp() throws Exception {
		vendorDTO_1 = new VendorDTO("Vendor 1", VendorController.BASE_URL + "/1");
		vendorDTO_2 = new VendorDTO("Vendor 2", VendorController.BASE_URL + "/2");
	}

	@Test
	public void testGetAllCustomers() throws Exception {
		//given

		VendorListDTO vendorListDTO = new VendorListDTO(Arrays.asList(vendorDTO_1, vendorDTO_2));

		given(vendorService.getAllVendors()).willReturn(vendorListDTO);

		mockMvc.perform(get(VendorController.BASE_URL)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.vendors", hasSize(2)));
	}

	@Test
	public void testGetCustomerById() throws Exception {

		//given
		given(vendorService.getVendorById(anyLong())).willReturn(vendorDTO_1);

		//when
		mockMvc.perform(get(VendorController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", equalTo(vendorDTO_1.getName())));
	}

	@Test
	public void createNewCustomer() throws Exception {
		//given
		given(vendorService.createNewVendor(vendorDTO_1)).willReturn(vendorDTO_1);

		//when/then
		mockMvc.perform(post(VendorController.BASE_URL)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(vendorDTO_1)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name", equalTo(vendorDTO_1.getName())));
	}


	@Test
	public void testUpdateCustomer() throws Exception {
		//given
		vendorDTO_1.setVendorUrl(vendorDTO_2.getVendorUrl());
		given(vendorService.updateVendorByPutVendorDTO(anyLong(), any(VendorDTO.class))).willReturn(vendorDTO_1);

		//when/then
		mockMvc.perform(put(VendorController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(vendorDTO_1)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", equalTo(vendorDTO_1.getName())))
				.andExpect(jsonPath("$.vendor_url", equalTo(vendorDTO_2.getVendorUrl())));
	}

	@Test
	public void testPatchCustomer() throws Exception {
//		VendorDTO v2 = new VendorDTO();
//		v2.setName("Michale");
//
//		VendorDTO returnedGenius = new VendorDTO();
//		returnedGenius.setVendorUrl(VendorController.BASE_URL + "/2");
//		when(vendorService.createNewVendor(v2)).thenReturn(v2);
//
//		when(vendorService.patchVendor(anyLong(), ArgumentMatchers.any(VendorDTO.class))).thenReturn(returnedGenius);

		//given
		given(vendorService.patchVendor(anyLong(), any(VendorDTO.class))).willReturn(vendorDTO_2);

		//when/then
		mockMvc.perform(patch(VendorController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(vendorDTO_2)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", equalTo(vendorDTO_2.getName())))
				.andExpect(jsonPath("$.vendor_url", equalTo(vendorDTO_2.getVendorUrl())));
	}


	@Test
	public void testDeleteByCustomerId() throws Exception {
		//when/then
		mockMvc.perform(delete(VendorController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		then(vendorService).should().deleteVendor(anyLong());
	}

	@Test
	public void testNotFoundException() throws Exception {

		when(vendorService.getVendorById(anyLong())).thenThrow(ResourceNotFoundException.class);

		mockMvc.perform(get(VendorController.BASE_URL + "/222")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());


	}
}