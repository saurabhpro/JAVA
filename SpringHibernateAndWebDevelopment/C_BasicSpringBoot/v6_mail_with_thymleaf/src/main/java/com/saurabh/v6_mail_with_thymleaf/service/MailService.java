package com.saurabh.v6_mail_with_thymleaf.service;

public interface MailService<T> {
	void sendEmail(T object);
}
