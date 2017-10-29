/*
 * Copyright 2017 Saurabh Kumar 29/10/17 5:36 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.rxjava.observable.b_composition.model;

public class User {

	private final String username;
	private final String emailAddress;
	private final UserSecurityStatus securityStatus;

	public User(String username, String emailAddress, UserSecurityStatus securityStatus) {
		this.username = username;
		this.emailAddress = emailAddress;
		this.securityStatus = securityStatus;
	}

	public String getUsername() {
		return username;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public UserSecurityStatus getSecurityStatus() {
		return securityStatus;
	}

	public String toJSON() {

		return "    { 'username' : \"" + username + "\", "
				+ " 'emailAddress' : \"" + emailAddress + "\","
				+ " 'securityStatus' : \"" + securityStatus.toString() + "\"},";
	}
}
