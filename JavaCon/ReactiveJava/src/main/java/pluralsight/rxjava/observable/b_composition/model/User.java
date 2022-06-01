/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.b_composition.model;

public record User(String username, String emailAddress,
                   UserSecurityStatus securityStatus) {

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
