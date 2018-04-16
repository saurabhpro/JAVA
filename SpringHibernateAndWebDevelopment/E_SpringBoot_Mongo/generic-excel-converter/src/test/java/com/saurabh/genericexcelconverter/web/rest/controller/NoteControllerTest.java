package com.saurabh.genericexcelconverter.web.rest.controller;

import com.saurabh.genericexcelconverter.api.constants.MessageConstants;
import com.saurabh.genericexcelconverter.util.BaseIntegrationTest;
import com.saurabh.genericexcelconverter.web.dto.NoteDTO;
import com.saurabh.genericexcelconverter.web.dto.ResponseDTO;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

class NoteControllerTest extends BaseIntegrationTest {

	@Test
	void testAddJusticeLeagueMember() throws Exception {

		NoteDTO flash = new NoteDTO(LocalDateTime.of(2018, 1, 1, 0, 0, 0).toString(), "super speed", "Central City");
		String jsonContent = mapper.writeValueAsString(flash);

		String response = mockMvc
				.perform(
						MockMvcRequestBuilders.get("/api/v1/addall")
								.contentType(MediaType.APPLICATION_JSON)
								.content(jsonContent)
				)
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andReturn()
				.getResponse()
				.getContentAsString();

		ResponseDTO expected = new ResponseDTO(ResponseDTO.Status.SUCCESS, MessageConstants.MEMBER_ADDED_SUCCESSFULLY);
		ResponseDTO receivedResponse = mapper.readValue(response, ResponseDTO.class);

		Assert.assertThat(receivedResponse, SamePropertyValuesAs.samePropertyValuesAs(expected));
	}
}