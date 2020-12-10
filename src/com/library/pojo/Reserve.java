package com.library.pojo;

/**
 * @author MSI-NB
 */
public class Reserve {
    private int resNumber;
    private String resDate;
    private String resStatus;
    private Integer copyNo;
    private Integer readerId;

    public int getResNumber() {
        return resNumber;
    }

    public void setResNumber(int resNumber) {
        this.resNumber = resNumber;
    }

    public String getResDate() {
        return resDate;
    }

    public void setResDate(String resDate) {
        this.resDate = resDate;
    }

    public String getResStatus() {
        return resStatus;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }

    public Integer getCopyNo() {
        return copyNo;
    }

    public void setCopyNo(Integer copyNo) {
        this.copyNo = copyNo;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }
}
