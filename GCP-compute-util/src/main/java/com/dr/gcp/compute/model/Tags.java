
package com.dr.gcp.compute.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Tags implements Serializable
{

    @SerializedName("fingerprint")
    @Expose
    private String fingerprint;
    @SerializedName("items")
    @Expose
    private List<String> items = null;
    private final static long serialVersionUID = 5002569254955223756L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tags() {
    }

    /**
     * 
     * @param fingerprint
     * @param items
     */
    public Tags(String fingerprint, List<String> items) {
        super();
        this.fingerprint = fingerprint;
        this.items = items;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("fingerprint", fingerprint).append("items", items).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fingerprint).append(items).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tags) == false) {
            return false;
        }
        Tags rhs = ((Tags) other);
        return new EqualsBuilder().append(fingerprint, rhs.fingerprint).append(items, rhs.items).isEquals();
    }

}
