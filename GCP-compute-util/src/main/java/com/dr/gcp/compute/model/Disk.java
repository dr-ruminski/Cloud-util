
package com.dr.gcp.compute.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Disk implements Serializable
{

    @SerializedName("autoDelete")
    @Expose
    private Boolean autoDelete;
    @SerializedName("boot")
    @Expose
    private Boolean boot;
    @SerializedName("deviceName")
    @Expose
    private String deviceName;
    @SerializedName("diskSizeGb")
    @Expose
    private String diskSizeGb;
    @SerializedName("guestOsFeatures")
    @Expose
    private List<GuestOsFeature> guestOsFeatures = null;
    @SerializedName("index")
    @Expose
    private Integer index;
    @SerializedName("interface")
    @Expose
    private String _interface;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("licenses")
    @Expose
    private List<String> licenses = null;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("type")
    @Expose
    private String type;
    private final static long serialVersionUID = 2498335119719273863L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Disk() {
    }

    /**
     * 
     * @param mode
     * @param licenses
     * @param kind
     * @param autoDelete
     * @param index
     * @param guestOsFeatures
     * @param source
     * @param boot
     * @param _interface
     * @param type
     * @param deviceName
     * @param diskSizeGb
     */
    public Disk(Boolean autoDelete, Boolean boot, String deviceName, String diskSizeGb, List<GuestOsFeature> guestOsFeatures, Integer index, String _interface, String kind, List<String> licenses, String mode, String source, String type) {
        super();
        this.autoDelete = autoDelete;
        this.boot = boot;
        this.deviceName = deviceName;
        this.diskSizeGb = diskSizeGb;
        this.guestOsFeatures = guestOsFeatures;
        this.index = index;
        this._interface = _interface;
        this.kind = kind;
        this.licenses = licenses;
        this.mode = mode;
        this.source = source;
        this.type = type;
    }

    public Boolean getAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(Boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    public Boolean getBoot() {
        return boot;
    }

    public void setBoot(Boolean boot) {
        this.boot = boot;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDiskSizeGb() {
        return diskSizeGb;
    }

    public void setDiskSizeGb(String diskSizeGb) {
        this.diskSizeGb = diskSizeGb;
    }

    public List<GuestOsFeature> getGuestOsFeatures() {
        return guestOsFeatures;
    }

    public void setGuestOsFeatures(List<GuestOsFeature> guestOsFeatures) {
        this.guestOsFeatures = guestOsFeatures;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getInterface() {
        return _interface;
    }

    public void setInterface(String _interface) {
        this._interface = _interface;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<String> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<String> licenses) {
        this.licenses = licenses;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("autoDelete", autoDelete).append("boot", boot).append("deviceName", deviceName).append("diskSizeGb", diskSizeGb).append("guestOsFeatures", guestOsFeatures).append("index", index).append("_interface", _interface).append("kind", kind).append("licenses", licenses).append("mode", mode).append("source", source).append("type", type).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(kind).append(index).append(guestOsFeatures).append(source).append(_interface).append(type).append(deviceName).append(mode).append(licenses).append(autoDelete).append(boot).append(diskSizeGb).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Disk) == false) {
            return false;
        }
        Disk rhs = ((Disk) other);
        return new EqualsBuilder().append(kind, rhs.kind).append(index, rhs.index).append(guestOsFeatures, rhs.guestOsFeatures).append(source, rhs.source).append(_interface, rhs._interface).append(type, rhs.type).append(deviceName, rhs.deviceName).append(mode, rhs.mode).append(licenses, rhs.licenses).append(autoDelete, rhs.autoDelete).append(boot, rhs.boot).append(diskSizeGb, rhs.diskSizeGb).isEquals();
    }

}
