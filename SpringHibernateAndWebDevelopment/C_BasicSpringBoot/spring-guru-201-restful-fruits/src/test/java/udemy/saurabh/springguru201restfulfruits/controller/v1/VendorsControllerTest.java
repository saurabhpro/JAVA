package udemy.saurabh.springguru201restfulfruits.controller.v1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.VendorsDTO;
import udemy.saurabh.springguru201restfulfruits.controller.RestResponseEntityExceptionHandler;
import udemy.saurabh.springguru201restfulfruits.model.exceptions.ResourceNotFoundException;
import udemy.saurabh.springguru201restfulfruits.service.IVendorService;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static udemy.saurabh.springguru201restfulfruits.controller.v1.AbstractRestControllerTest.asJsonString;

public class VendorsControllerTest {

	@Mock
	private
	IVendorService vendorService;

	@InjectMocks
	private    // inject @Mock to this controller, so no need to do controller = new Contoller(service)
			VendorController vendorController;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(vendorController)
				.setControllerAdvice(new RestResponseEntityExceptionHandler())
				.build();
	}

	@Test
	public void testGetAllCustomers() throws Exception {
		//given
		VendorsDTO v1 = new VendorsDTO();
		v1.setName("Michale");
		v1.setVendorUrl(VendorController.BASE_URL + "/1");

		VendorsDTO v2 = new VendorsDTO();
		v2.setName("Michale2");
		v2.setVendorUrl(VendorController.BASE_URL + "/2");

		when(vendorService.getAllVendors()).thenReturn(Arrays.asList(v1, v2));

		mockMvc.perform(get(VendorController.BASE_URL)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.vendors", hasSize(2)));
	}

	@Test
	public void testGetCustomerById() throws Exception {

		//given
		VendorsDTO v2 = new VendorsDTO();
		v2.setName("Michale");
		v2.setVendorUrl(VendorController.BASE_URL + "/1");

		when(vendorService.getVendorById(anyLong())).thenReturn(v2);

		//when
		mockMvc.perform(get(VendorController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", equalTo("Michale")));
	}

	@Test
	public void createNewCustomer() throws Exception {
		//given
		VendorsDTO v2 = new VendorsDTO();
		v2.setName("Michale");

		VendorsDTO returnedGenius = new VendorsDTO();
		returnedGenius.setName(v2.getName());
		returnedGenius.setVendorUrl(VendorController.BASE_URL + "/1");

		when(vendorService.createNewVendor(v2)).thenReturn(returnedGenius);

		//when/then
		mockMvc.perform(post(VendorController.BASE_URL)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(v2)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name", equalTo("Michale")))
				.andExpect(jsonPath("$.vendor_url", equalTo(VendorController.BASE_URL + "/1"))); // from jsonProperty
	}


	@Test
	public void testUpdateCustomer() throws Exception {
		//given
		VendorsDTO v2 = new VendorsDTO();
		v2.setName("Michale");

		VendorsDTO returnedGenius = new VendorsDTO();
		returnedGenius.setName(v2.getName());
		returnedGenius.setVendorUrl(VendorController.BASE_URL + "/1");
		when(vendorService.createNewVendor(v2)).thenReturn(v2);

		when(vendorService.updateVendorByPutVendorDTO(anyLong(), ArgumentMatchers.any(VendorsDTO.class))).thenReturn(returnedGenius);

		//when/then
		mockMvc.perform(put(VendorController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(v2)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", equalTo("Michale")))
				.andExpect(jsonPath("$.vendor_url", equalTo(VendorController.BASE_URL + "/1")));
	}

	@Test
	public void testPatchCustomer() throws Exception {
		//given
		VendorsDTO v2 = new VendorsDTO();
		v2.setName("Michale");

		VendorsDTO returnedGenius = new VendorsDTO();
		returnedGenius.setVendorUrl(VendorController.BASE_URL + "/2");
		when(vendorService.createNewVendor(v2)).thenReturn(v2);

		when(vendorService.patchVendor(anyLong(), ArgumentMatchers.any(VendorsDTO.class))).thenReturn(returnedGenius);

		//when/then
		mockMvc.perform(patch(VendorController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(v2)))
				.andExpect(status().isOk())
				//.andExpect(jsonPath("$.name", equalTo("Michale")))
				.andExpect(jsonPath("$.vendor_url", equalTo(VendorController.BASE_URL + "/2")));
	}


	@Test
	public void testDeleteByCustomerId() throws Exception {
		//when/then
		mockMvc.perform(delete(VendorController.BASE_URL + "/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		verify(vendorService, times(1)).deleteVendor(anyLong());
	}

	@Test
	public void testNotFoundException() throws Exception {

		when(vendorService.getVendorById(anyLong())).thenThrow(ResourceNotFoundException.class);

		mockMvc.perform(get(VendorController.BASE_URL + "/222")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
}