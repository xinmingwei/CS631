package com.library.pojo;

import java.util.Date;

/**
 * @author MSI-NB
 */

public class Document {
    private Integer docId;
    private String title;
    private String pDate;
    private Integer publishId;

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    @Override
    public String toString() {
        return "Document{" +
                "docId=" + docId +
                ", title='" + title + '\'' +
                ", pDate='" + pDate + '\'' +
                ", publishId='" + publishId + '\'' +
                '}';
    }
}
