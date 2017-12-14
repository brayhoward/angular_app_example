package com.gewaukesha.lifecycle.model.seshat;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author <a href="mailto:alexander.rosemann@ge.com">Alexander Rosemann (502550922)</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String name;
    private Boolean isInternal;
    private Boolean isAdmin;
    private String email;
    private String fullName;
    private Boolean hasActiveContract;

    public User() {

    }

    public User(String name, Boolean isInternal, Boolean isAdmin, String email, String fullName, Boolean hasActiveContract) {

        this.name = name;
        this.isInternal = isInternal;
        this.isAdmin = isAdmin;
        this.email = email;
        this.fullName = fullName;
        this.hasActiveContract = hasActiveContract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(Boolean isInternal) {
        this.isInternal = isInternal;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getHasActiveContract() {
        return hasActiveContract;
    }

    public void setHasActiveContract(Boolean hasActiveContract) {
        this.hasActiveContract = hasActiveContract;
    }
}