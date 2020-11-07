
package com.dr.gcp.compute.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Metadata implements Serializable
{

    @SerializedName("fingerprint")
    @Expose
    private String fingerprint;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    private final static long serialVersionUID = -7244660928077584738L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metadata() {
    }

    /**
     * 
     * @param kind
     * @param fingerprint
     * @param items
     */
    public Metadata(String fingerprint, String kind, List<Item> items) {
        super();
        this.fingerprint = fingerprint;
        this.kind = kind;
        this.items = items;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("fingerprint", fingerprint).append("kind", kind).append("items", items).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fingerprint).append(items).append(kind).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Metadata) == false) {
            return false;
        }
        Metadata rhs = ((Metadata) other);
        return new EqualsBuilder().append(fingerprint, rhs.fingerprint).append(items, rhs.items).append(kind, rhs.kind).isEquals();
    }

}
