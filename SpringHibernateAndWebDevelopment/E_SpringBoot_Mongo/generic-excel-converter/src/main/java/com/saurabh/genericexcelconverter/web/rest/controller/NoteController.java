package com.saurabh.genericexcelconverter.web.rest.controller;

import com.saurabh.genericexcelconverter.api.constants.MessageConstants;
import com.saurabh.genericexcelconverter.api.model.MonthNotes;
import com.saurabh.genericexcelconverter.api.service.ExcelParser;
import com.saurabh.genericexcelconverter.api.service.NoteService;
import com.saurabh.genericexcelconverter.web.dto.NoteDTO;
import com.saurabh.genericexcelconverter.web.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NoteController {
	private final NoteService noteService;
	private final ExcelParser excl;

	@Autowired
	public NoteController(NoteService noteService, ExcelParser excl) {
		this.noteService = noteService;
		this.excl = excl;
	}

	/**
	 * This method will be used to add justice league members to the system.
	 *
	 * @param justiceLeagueMember the justice league member to add.
	 * @return an instance of {@link ResponseDTO} which will notify whether
	 * adding the member was successful.
	 */
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, path = "/addMember", produces = {
			MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseDTO addNote(@Valid @RequestBody NoteDTO justiceLeagueMember) {

		ResponseDTO responseDTO = new ResponseDTO(ResponseDTO.Status.SUCCESS,
				MessageConstants.MEMBER_ADDED_SUCCESSFULLY);
		try {
			noteService.addNote(justiceLeagueMember);
		} catch (Exception e) {
			responseDTO.setStatus(ResponseDTO.Status.FAIL);
			responseDTO.setMessage(e.getMessage());
		}
		return responseDTO;
	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@GetMapping("/2007")
	public List<MonthNotes> get2007ContentByMonth() {
		return excl.parse(2007);
	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@GetMapping("/2008")
	public List<MonthNotes> get2008ContentByMonth() {
		return excl.parse(2008);
	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	@GetMapping("addall")
	public ResponseDTO addNote() {

		ResponseDTO responseDTO = new ResponseDTO(ResponseDTO.Status.SUCCESS,
				MessageConstants.MEMBER_ADDED_SUCCESSFULLY);
		try {
			for (MonthNotes notes : excl.parse(2007))
				noteService.addNote(notes);
			for (MonthNotes notes : excl.parse(2008))
				noteService.addNote(notes);
		} catch (Exception e) {
			responseDTO.setStatus(ResponseDTO.Status.FAIL);
			responseDTO.setMessage(e.getMessage());
		}
		return responseDTO;
	}
}
