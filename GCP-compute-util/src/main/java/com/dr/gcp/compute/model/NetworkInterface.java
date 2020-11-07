
package com.dr.gcp.compute.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class NetworkInterface implements Serializable
{

    @SerializedName("accessConfigs")
    @Expose
    private List<AccessConfig> accessConfigs = null;
    @SerializedName("fingerprint")
    @Expose
    private String fingerprint;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("network")
    @Expose
    private String network;
    @SerializedName("networkIP")
    @Expose
    private String networkIP;
    @SerializedName("subnetwork")
    @Expose
    private String subnetwork;
    private final static long serialVersionUID = -4349055948306157177L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkInterface() {
    }

    /**
     * 
     * @param kind
     * @param networkIP
     * @param subnetwork
     * @param fingerprint
     * @param name
     * @param accessConfigs
     * @param network
     */
    public NetworkInterface(List<AccessConfig> accessConfigs, String fingerprint, String kind, String name, String network, String networkIP, String subnetwork) {
        super();
        this.accessConfigs = accessConfigs;
        this.fingerprint = fingerprint;
        this.kind = kind;
        this.name = name;
        this.network = network;
        this.networkIP = networkIP;
        this.subnetwork = subnetwork;
    }

    public List<AccessConfig> getAccessConfigs() {
        return accessConfigs;
    }

    public void setAccessConfigs(List<AccessConfig> accessConfigs) {
        this.accessConfigs = accessConfigs;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getNetworkIP() {
        return networkIP;
    }

    public void setNetworkIP(String networkIP) {
        this.networkIP = networkIP;
    }

    public String getSubnetwork() {
        return subnetwork;
    }

    public void setSubnetwork(String subnetwork) {
        this.subnetwork = subnetwork;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("accessConfigs", accessConfigs).append("fingerprint", fingerprint).append("kind", kind).append("name", name).append("network", network).append("networkIP", networkIP).append("subnetwork", subnetwork).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(kind).append(networkIP).append(subnetwork).append(fingerprint).append(name).append(accessConfigs).append(network).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NetworkInterface) == false) {
            return false;
        }
        NetworkInterface rhs = ((NetworkInterface) other);
        return new EqualsBuilder().append(kind, rhs.kind).append(networkIP, rhs.networkIP).append(subnetwork, rhs.subnetwork).append(fingerprint, rhs.fingerprint).append(name, rhs.name).append(accessConfigs, rhs.accessConfigs).append(network, rhs.network).isEquals();
    }

}
