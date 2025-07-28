package com.seekho.api.dto;

import java.util.Date;

public class FollowUpDTO {
    private Integer followUpId;
    private Integer enquiryId;
    private Date nextFollowUpDate;
    private String remarks;
    private Integer staffId;

    public Integer getFollowUpId() {
        return followUpId;
    }

    public void setFollowUpId(Integer followUpId) {
        this.followUpId = followUpId;
    }

    public Integer getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(Integer enquiryId) {
        this.enquiryId = enquiryId;
    }

    public Date getNextFollowUpDate() {
        return nextFollowUpDate;
    }

    public void setNextFollowUpDate(Date nextFollowUpDate) {
        this.nextFollowUpDate = nextFollowUpDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}
