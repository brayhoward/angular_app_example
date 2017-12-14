package com.gewaukesha.lifecycle.model.seshat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author <a href="mailto:alexander.rosemann@ge.com">Alexander Rosemann (502550922)</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthInfo {
    private String token;
    private User user;

    public AuthInfo(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public AuthInfo() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

