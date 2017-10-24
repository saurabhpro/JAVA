package com.saurabh.v2_file_uploading_my.storage.controllers;

import com.saurabh.v2_file_uploading_my.storage.exceptions.StorageException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


//http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-error-handling


@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

//    //StandardServletMultipartResolver
//    @ExceptionHandler(MultipartException.class)
//    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
//
//        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
//        return "redirect:/uploadStatus";
//
//    }
//
//    //CommonsMultipartResolver
//    @ExceptionHandler(StorageException.class)
//    public String handleError2(StorageException e, RedirectAttributes redirectAttributes) {
//
//        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
//        return "redirect:/uploadStatus";
//
//    }

	@Value("${spring.servlet.multipart.max-file-size}")
	String max_upload_size;

//	@ExceptionHandler(StorageException.class)
//	ResponseEntity<StorageException> handleControllerException(HttpServletRequest request, Throwable ex) {
//
//		HttpStatus status = getStatus(request);
//
//		return new ResponseEntity<>(new StorageException("Attachment size exceeds the allowable limit! (" + max_upload_size + ")"), status);
//	}


	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}

	@ExceptionHandler({StorageException.class, FileUploadBase.SizeLimitExceededException.class, IllegalStateException.class})
	public ModelAndView handleBadRequests(HttpServletRequest request, Exception exception) {

		log.error("Handling bad request exception");
		log.error(exception.getMessage());

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("error/error");
		modelAndView.addObject("exception", exception);
		modelAndView.setStatus(getStatus(request));

		return modelAndView;
	}
}