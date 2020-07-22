
package com.dr.gcp.compute.vm.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ShieldedInstanceConfig implements Serializable
{

    @SerializedName("enableIntegrityMonitoring")
    @Expose
    private Boolean enableIntegrityMonitoring;
    @SerializedName("enableSecureBoot")
    @Expose
    private Boolean enableSecureBoot;
    @SerializedName("enableVtpm")
    @Expose
    private Boolean enableVtpm;
    private final static long serialVersionUID = -7890724585950484242L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ShieldedInstanceConfig() {
    }

    /**
     * 
     * @param enableVtpm
     * @param enableIntegrityMonitoring
     * @param enableSecureBoot
     */
    public ShieldedInstanceConfig(Boolean enableIntegrityMonitoring, Boolean enableSecureBoot, Boolean enableVtpm) {
        super();
        this.enableIntegrityMonitoring = enableIntegrityMonitoring;
        this.enableSecureBoot = enableSecureBoot;
        this.enableVtpm = enableVtpm;
    }

    public Boolean getEnableIntegrityMonitoring() {
        return enableIntegrityMonitoring;
    }

    public void setEnableIntegrityMonitoring(Boolean enableIntegrityMonitoring) {
        this.enableIntegrityMonitoring = enableIntegrityMonitoring;
    }

    public Boolean getEnableSecureBoot() {
        return enableSecureBoot;
    }

    public void setEnableSecureBoot(Boolean enableSecureBoot) {
        this.enableSecureBoot = enableSecureBoot;
    }

    public Boolean getEnableVtpm() {
        return enableVtpm;
    }

    public void setEnableVtpm(Boolean enableVtpm) {
        this.enableVtpm = enableVtpm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("enableIntegrityMonitoring", enableIntegrityMonitoring).append("enableSecureBoot", enableSecureBoot).append("enableVtpm", enableVtpm).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(enableIntegrityMonitoring).append(enableSecureBoot).append(enableVtpm).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ShieldedInstanceConfig) == false) {
            return false;
        }
        ShieldedInstanceConfig rhs = ((ShieldedInstanceConfig) other);
        return new EqualsBuilder().append(enableIntegrityMonitoring, rhs.enableIntegrityMonitoring).append(enableSecureBoot, rhs.enableSecureBoot).append(enableVtpm, rhs.enableVtpm).isEquals();
    }

}
