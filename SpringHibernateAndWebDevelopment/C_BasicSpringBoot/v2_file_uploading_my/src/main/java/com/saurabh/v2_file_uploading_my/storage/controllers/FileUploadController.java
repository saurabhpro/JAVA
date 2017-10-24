package com.saurabh.v2_file_uploading_my.storage.controllers;

import com.saurabh.v2_file_uploading_my.storage.exceptions.StorageFileNotFoundException;
import com.saurabh.v2_file_uploading_my.storage.service.IStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.stream.Collectors;

@Controller
public class FileUploadController {

	private final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	private final IStorageService IStorageService;

	@Autowired
	public FileUploadController(IStorageService IStorageService) {
		this.IStorageService = IStorageService;
	}

	@GetMapping("/")
	public String listUploadedFiles(Model model) {

		model.addAttribute("files", IStorageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(
						FileUploadController.class,
						"serveFile",
						path.getFileName().toString()).build().toString())
				.collect(Collectors.toList()));

		return "uploadForm";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = IStorageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
	                               RedirectAttributes redirectAttributes) {

		logger.debug("Single file upload!");

		IStorageService.store(file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}
}
