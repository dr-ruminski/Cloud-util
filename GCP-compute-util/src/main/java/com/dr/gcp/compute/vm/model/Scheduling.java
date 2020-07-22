
package com.dr.gcp.compute.vm.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Scheduling implements Serializable
{

    @SerializedName("automaticRestart")
    @Expose
    private Boolean automaticRestart;
    @SerializedName("onHostMaintenance")
    @Expose
    private String onHostMaintenance;
    @SerializedName("preemptible")
    @Expose
    private Boolean preemptible;
    private final static long serialVersionUID = -6075064275698060853L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Scheduling() {
    }

    /**
     * 
     * @param automaticRestart
     * @param preemptible
     * @param onHostMaintenance
     */
    public Scheduling(Boolean automaticRestart, String onHostMaintenance, Boolean preemptible) {
        super();
        this.automaticRestart = automaticRestart;
        this.onHostMaintenance = onHostMaintenance;
        this.preemptible = preemptible;
    }

    public Boolean getAutomaticRestart() {
        return automaticRestart;
    }

    public void setAutomaticRestart(Boolean automaticRestart) {
        this.automaticRestart = automaticRestart;
    }

    public String getOnHostMaintenance() {
        return onHostMaintenance;
    }

    public void setOnHostMaintenance(String onHostMaintenance) {
        this.onHostMaintenance = onHostMaintenance;
    }

    public Boolean getPreemptible() {
        return preemptible;
    }

    public void setPreemptible(Boolean preemptible) {
        this.preemptible = preemptible;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("automaticRestart", automaticRestart).append("onHostMaintenance", onHostMaintenance).append("preemptible", preemptible).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(automaticRestart).append(preemptible).append(onHostMaintenance).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Scheduling) == false) {
            return false;
        }
        Scheduling rhs = ((Scheduling) other);
        return new EqualsBuilder().append(automaticRestart, rhs.automaticRestart).append(preemptible, rhs.preemptible).append(onHostMaintenance, rhs.onHostMaintenance).isEquals();
    }

}
