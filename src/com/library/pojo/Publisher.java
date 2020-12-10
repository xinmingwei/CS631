package com.library.pojo;

/**
 * @author MSI-NB
 */
public class Publisher {
    private Integer publisherId;
    private String pubName;
    private String address;

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", pubName='" + pubName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
