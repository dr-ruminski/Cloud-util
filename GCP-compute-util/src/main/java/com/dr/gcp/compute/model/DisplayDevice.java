
package com.dr.gcp.compute.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DisplayDevice implements Serializable
{

    @SerializedName("enableDisplay")
    @Expose
    private Boolean enableDisplay;
    private final static long serialVersionUID = 1443748061913002512L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DisplayDevice() {
    }

    /**
     * 
     * @param enableDisplay
     */
    public DisplayDevice(Boolean enableDisplay) {
        super();
        this.enableDisplay = enableDisplay;
    }

    public Boolean getEnableDisplay() {
        return enableDisplay;
    }

    public void setEnableDisplay(Boolean enableDisplay) {
        this.enableDisplay = enableDisplay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("enableDisplay", enableDisplay).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(enableDisplay).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DisplayDevice) == false) {
            return false;
        }
        DisplayDevice rhs = ((DisplayDevice) other);
        return new EqualsBuilder().append(enableDisplay, rhs.enableDisplay).isEquals();
    }

}
