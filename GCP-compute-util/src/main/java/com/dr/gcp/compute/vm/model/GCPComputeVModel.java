
package com.dr.gcp.compute.vm.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class GCPComputeVModel implements Serializable
{

    @SerializedName("canIpForward")
    @Expose
    private Boolean canIpForward;
    @SerializedName("cpuPlatform")
    @Expose
    private String cpuPlatform;
    @SerializedName("creationTimestamp")
    @Expose
    private String creationTimestamp;
    @SerializedName("deletionProtection")
    @Expose
    private Boolean deletionProtection;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("disks")
    @Expose
    private List<Disk> disks = null;
    @SerializedName("displayDevice")
    @Expose
    private DisplayDevice displayDevice;
    @SerializedName("fingerprint")
    @Expose
    private String fingerprint;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("labelFingerprint")
    @Expose
    private String labelFingerprint;
    @SerializedName("machineType")
    @Expose
    private String machineType;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("networkInterfaces")
    @Expose
    private List<NetworkInterface> networkInterfaces = null;
    @SerializedName("reservationAffinity")
    @Expose
    private ReservationAffinity reservationAffinity;
    @SerializedName("scheduling")
    @Expose
    private Scheduling scheduling;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;
    @SerializedName("serviceAccounts")
    @Expose
    private List<ServiceAccount> serviceAccounts = null;
    @SerializedName("shieldedInstanceConfig")
    @Expose
    private ShieldedInstanceConfig shieldedInstanceConfig;
    @SerializedName("shieldedInstanceIntegrityPolicy")
    @Expose
    private ShieldedInstanceIntegrityPolicy shieldedInstanceIntegrityPolicy;
    @SerializedName("startRestricted")
    @Expose
    private Boolean startRestricted;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tags")
    @Expose
    private Tags tags;
    @SerializedName("zone")
    @Expose
    private String zone;
    private final static long serialVersionUID = 2781466647479390325L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GCPComputeVModel() {
    }

    /**
     * 
     * @param metadata
     * @param serviceAccounts
     * @param shieldedInstanceIntegrityPolicy
     * @param disks
     * @param displayDevice
     * @param reservationAffinity
     * @param description
     * @param cpuPlatform
     * @param labelFingerprint
     * @param deletionProtection
     * @param zone
     * @param creationTimestamp
     * @param fingerprint
     * @param scheduling
     * @param id
     * @param machineType
     * @param canIpForward
     * @param shieldedInstanceConfig
     * @param kind
     * @param startRestricted
     * @param selfLink
     * @param tags
     * @param networkInterfaces
     * @param name
     * @param status
     */
    public GCPComputeVModel(Boolean canIpForward, String cpuPlatform, String creationTimestamp, Boolean deletionProtection, String description, List<Disk> disks, DisplayDevice displayDevice, String fingerprint, String id, String kind, String labelFingerprint, String machineType, Metadata metadata, String name, List<NetworkInterface> networkInterfaces, ReservationAffinity reservationAffinity, Scheduling scheduling, String selfLink, List<ServiceAccount> serviceAccounts, ShieldedInstanceConfig shieldedInstanceConfig, ShieldedInstanceIntegrityPolicy shieldedInstanceIntegrityPolicy, Boolean startRestricted, String status, Tags tags, String zone) {
        super();
        this.canIpForward = canIpForward;
        this.cpuPlatform = cpuPlatform;
        this.creationTimestamp = creationTimestamp;
        this.deletionProtection = deletionProtection;
        this.description = description;
        this.disks = disks;
        this.displayDevice = displayDevice;
        this.fingerprint = fingerprint;
        this.id = id;
        this.kind = kind;
        this.labelFingerprint = labelFingerprint;
        this.machineType = machineType;
        this.metadata = metadata;
        this.name = name;
        this.networkInterfaces = networkInterfaces;
        this.reservationAffinity = reservationAffinity;
        this.scheduling = scheduling;
        this.selfLink = selfLink;
        this.serviceAccounts = serviceAccounts;
        this.shieldedInstanceConfig = shieldedInstanceConfig;
        this.shieldedInstanceIntegrityPolicy = shieldedInstanceIntegrityPolicy;
        this.startRestricted = startRestricted;
        this.status = status;
        this.tags = tags;
        this.zone = zone;
    }

    public Boolean getCanIpForward() {
        return canIpForward;
    }

    public void setCanIpForward(Boolean canIpForward) {
        this.canIpForward = canIpForward;
    }

    public String getCpuPlatform() {
        return cpuPlatform;
    }

    public void setCpuPlatform(String cpuPlatform) {
        this.cpuPlatform = cpuPlatform;
    }

    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Boolean getDeletionProtection() {
        return deletionProtection;
    }

    public void setDeletionProtection(Boolean deletionProtection) {
        this.deletionProtection = deletionProtection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Disk> getDisks() {
        return disks;
    }

    public void setDisks(List<Disk> disks) {
        this.disks = disks;
    }

    public DisplayDevice getDisplayDevice() {
        return displayDevice;
    }

    public void setDisplayDevice(DisplayDevice displayDevice) {
        this.displayDevice = displayDevice;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLabelFingerprint() {
        return labelFingerprint;
    }

    public void setLabelFingerprint(String labelFingerprint) {
        this.labelFingerprint = labelFingerprint;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NetworkInterface> getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(List<NetworkInterface> networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
    }

    public ReservationAffinity getReservationAffinity() {
        return reservationAffinity;
    }

    public void setReservationAffinity(ReservationAffinity reservationAffinity) {
        this.reservationAffinity = reservationAffinity;
    }

    public Scheduling getScheduling() {
        return scheduling;
    }

    public void setScheduling(Scheduling scheduling) {
        this.scheduling = scheduling;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public List<ServiceAccount> getServiceAccounts() {
        return serviceAccounts;
    }

    public void setServiceAccounts(List<ServiceAccount> serviceAccounts) {
        this.serviceAccounts = serviceAccounts;
    }

    public ShieldedInstanceConfig getShieldedInstanceConfig() {
        return shieldedInstanceConfig;
    }

    public void setShieldedInstanceConfig(ShieldedInstanceConfig shieldedInstanceConfig) {
        this.shieldedInstanceConfig = shieldedInstanceConfig;
    }

    public ShieldedInstanceIntegrityPolicy getShieldedInstanceIntegrityPolicy() {
        return shieldedInstanceIntegrityPolicy;
    }

    public void setShieldedInstanceIntegrityPolicy(ShieldedInstanceIntegrityPolicy shieldedInstanceIntegrityPolicy) {
        this.shieldedInstanceIntegrityPolicy = shieldedInstanceIntegrityPolicy;
    }

    public Boolean getStartRestricted() {
        return startRestricted;
    }

    public void setStartRestricted(Boolean startRestricted) {
        this.startRestricted = startRestricted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("canIpForward", canIpForward).append("cpuPlatform", cpuPlatform).append("creationTimestamp", creationTimestamp).append("deletionProtection", deletionProtection).append("description", description).append("disks", disks).append("displayDevice", displayDevice).append("fingerprint", fingerprint).append("id", id).append("kind", kind).append("labelFingerprint", labelFingerprint).append("machineType", machineType).append("metadata", metadata).append("name", name).append("networkInterfaces", networkInterfaces).append("reservationAffinity", reservationAffinity).append("scheduling", scheduling).append("selfLink", selfLink).append("serviceAccounts", serviceAccounts).append("shieldedInstanceConfig", shieldedInstanceConfig).append("shieldedInstanceIntegrityPolicy", shieldedInstanceIntegrityPolicy).append("startRestricted", startRestricted).append("status", status).append("tags", tags).append("zone", zone).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(metadata).append(serviceAccounts).append(shieldedInstanceIntegrityPolicy).append(disks).append(displayDevice).append(reservationAffinity).append(description).append(cpuPlatform).append(labelFingerprint).append(deletionProtection).append(zone).append(creationTimestamp).append(fingerprint).append(scheduling).append(id).append(machineType).append(canIpForward).append(shieldedInstanceConfig).append(kind).append(startRestricted).append(selfLink).append(tags).append(networkInterfaces).append(name).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GCPComputeVModel) == false) {
            return false;
        }
        GCPComputeVModel rhs = ((GCPComputeVModel) other);
        return new EqualsBuilder().append(metadata, rhs.metadata).append(serviceAccounts, rhs.serviceAccounts).append(shieldedInstanceIntegrityPolicy, rhs.shieldedInstanceIntegrityPolicy).append(disks, rhs.disks).append(displayDevice, rhs.displayDevice).append(reservationAffinity, rhs.reservationAffinity).append(description, rhs.description).append(cpuPlatform, rhs.cpuPlatform).append(labelFingerprint, rhs.labelFingerprint).append(deletionProtection, rhs.deletionProtection).append(zone, rhs.zone).append(creationTimestamp, rhs.creationTimestamp).append(fingerprint, rhs.fingerprint).append(scheduling, rhs.scheduling).append(id, rhs.id).append(machineType, rhs.machineType).append(canIpForward, rhs.canIpForward).append(shieldedInstanceConfig, rhs.shieldedInstanceConfig).append(kind, rhs.kind).append(startRestricted, rhs.startRestricted).append(selfLink, rhs.selfLink).append(tags, rhs.tags).append(networkInterfaces, rhs.networkInterfaces).append(name, rhs.name).append(status, rhs.status).isEquals();
    }

}
