
package com.dr.gcp.compute.vm.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ReservationAffinity implements Serializable
{

    @SerializedName("consumeReservationType")
    @Expose
    private String consumeReservationType;
    private final static long serialVersionUID = -5741353124052900687L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReservationAffinity() {
    }

    /**
     * 
     * @param consumeReservationType
     */
    public ReservationAffinity(String consumeReservationType) {
        super();
        this.consumeReservationType = consumeReservationType;
    }

    public String getConsumeReservationType() {
        return consumeReservationType;
    }

    public void setConsumeReservationType(String consumeReservationType) {
        this.consumeReservationType = consumeReservationType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("consumeReservationType", consumeReservationType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(consumeReservationType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReservationAffinity) == false) {
            return false;
        }
        ReservationAffinity rhs = ((ReservationAffinity) other);
        return new EqualsBuilder().append(consumeReservationType, rhs.consumeReservationType).isEquals();
    }

}
