
package com.dr.gcp.compute.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ServiceAccount implements Serializable
{

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("scopes")
    @Expose
    private List<String> scopes = null;
    private final static long serialVersionUID = 588379798273824064L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceAccount() {
    }

    /**
     * 
     * @param scopes
     * @param email
     */
    public ServiceAccount(String email, List<String> scopes) {
        super();
        this.email = email;
        this.scopes = scopes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("email", email).append("scopes", scopes).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(email).append(scopes).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ServiceAccount) == false) {
            return false;
        }
        ServiceAccount rhs = ((ServiceAccount) other);
        return new EqualsBuilder().append(email, rhs.email).append(scopes, rhs.scopes).isEquals();
    }

}
