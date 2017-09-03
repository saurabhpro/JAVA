package springmvc.login.service;

import org.springframework.stereotype.Service;

/**
 * Created by saurabhkumar on 03/09/17.
 */
@Service
public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("saurabh") && password.equals("123");
	}

}
