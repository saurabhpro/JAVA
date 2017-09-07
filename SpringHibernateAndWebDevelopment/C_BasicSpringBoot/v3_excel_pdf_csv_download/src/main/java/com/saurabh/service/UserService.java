package com.saurabh.service;

import com.saurabh.model.User;
import com.saurabh.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UserService {

	private final String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String candidateNum = "0123456789";


	private final Utils appUtil;

	@Autowired
	public UserService(Utils appUtil) {
		this.appUtil = appUtil;
	}

	public List<User> findAllUsers() {


		List<User> users = IntStream.rangeClosed(1, 20)
				.mapToObj(i -> new User(appUtil.generateRandomChars(candidateChars, 10), appUtil.generateRandomChars(candidateChars, 10), appUtil.generateRandonInteger(i),
						appUtil.generateRandomChars(candidateChars, 15), appUtil.generateRandomChars(candidateChars, 15), appUtil.generateRandomChars(candidateChars, 20),
						appUtil.generateRandomChars(candidateChars, 10), appUtil.generateRandomChars(candidateChars, 10), appUtil.generateRandomChars(candidateNum, 10)))
				.collect(Collectors.toList());

		return users;

	}
}