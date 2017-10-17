package com.saurabh.service;

public interface MailService<T> {
	void sendEmail(T object);
}
