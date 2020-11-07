
package com.dr.gcp.compute.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ShieldedInstanceIntegrityPolicy implements Serializable
{

    @SerializedName("updateAutoLearnPolicy")
    @Expose
    private Boolean updateAutoLearnPolicy;
    private final static long serialVersionUID = -4229311193706946503L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ShieldedInstanceIntegrityPolicy() {
    }

    /**
     * 
     * @param updateAutoLearnPolicy
     */
    public ShieldedInstanceIntegrityPolicy(Boolean updateAutoLearnPolicy) {
        super();
        this.updateAutoLearnPolicy = updateAutoLearnPolicy;
    }

    public Boolean getUpdateAutoLearnPolicy() {
        return updateAutoLearnPolicy;
    }

    public void setUpdateAutoLearnPolicy(Boolean updateAutoLearnPolicy) {
        this.updateAutoLearnPolicy = updateAutoLearnPolicy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("updateAutoLearnPolicy", updateAutoLearnPolicy).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(updateAutoLearnPolicy).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ShieldedInstanceIntegrityPolicy) == false) {
            return false;
        }
        ShieldedInstanceIntegrityPolicy rhs = ((ShieldedInstanceIntegrityPolicy) other);
        return new EqualsBuilder().append(updateAutoLearnPolicy, rhs.updateAutoLearnPolicy).isEquals();
    }

}
