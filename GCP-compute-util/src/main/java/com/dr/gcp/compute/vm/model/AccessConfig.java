
package com.dr.gcp.compute.vm.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AccessConfig implements Serializable
{

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("networkTier")
    @Expose
    private String networkTier;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("natIP")
    @Expose
    private String natIP;
    private final static long serialVersionUID = 3527692925349587828L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AccessConfig() {
    }

    /**
     * 
     * @param natIP
     * @param networkTier
     * @param kind
     * @param name
     * @param type
     */
    public AccessConfig(String kind, String name, String networkTier, String type, String natIP) {
        super();
        this.kind = kind;
        this.name = name;
        this.networkTier = networkTier;
        this.type = type;
        this.natIP = natIP;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetworkTier() {
        return networkTier;
    }

    public void setNetworkTier(String networkTier) {
        this.networkTier = networkTier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNatIP() {
        return natIP;
    }

    public void setNatIP(String natIP) {
        this.natIP = natIP;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("kind", kind).append("name", name).append("networkTier", networkTier).append("type", type).append("natIP", natIP).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(natIP).append(networkTier).append(type).append(kind).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccessConfig) == false) {
            return false;
        }
        AccessConfig rhs = ((AccessConfig) other);
        return new EqualsBuilder().append(name, rhs.name).append(natIP, rhs.natIP).append(networkTier, rhs.networkTier).append(type, rhs.type).append(kind, rhs.kind).isEquals();
    }

}
