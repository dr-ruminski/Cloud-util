
package com.dr.gcp.compute.vm.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class GuestOsFeature implements Serializable
{

    @SerializedName("type")
    @Expose
    private String type;
    private final static long serialVersionUID = 3373708480844910844L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GuestOsFeature() {
    }

    /**
     * 
     * @param type
     */
    public GuestOsFeature(String type) {
        super();
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GuestOsFeature) == false) {
            return false;
        }
        GuestOsFeature rhs = ((GuestOsFeature) other);
        return new EqualsBuilder().append(type, rhs.type).isEquals();
    }

}
