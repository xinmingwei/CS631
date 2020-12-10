package com.library.pojo;

/**
 * @author MSI-NB
 */
public class Journal extends Document {
    private Integer volumeNo;
    private Integer issieNo;
    private String scope;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getVolumeNo() {
        return volumeNo;
    }

    public void setVolumeNo(Integer volumeNo) {
        this.volumeNo = volumeNo;
    }

    public Integer getIssieNo() {
        return issieNo;
    }

    public void setIssieNo(Integer issieNo) {
        this.issieNo = issieNo;
    }
}
