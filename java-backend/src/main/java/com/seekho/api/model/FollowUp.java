package com.seekho.api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "follow_ups")
public class FollowUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FollowUpID")
    private Integer followUpId;

    @ManyToOne
    @JoinColumn(name = "EnquiryID")
    private Enquiry enquiry;

    @Column(name = "NextFollowUpDate")
    private Date nextFollowUpDate;

    @Column(name = "Remarks")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "StaffID")
    private Staff staff;

    // Getters and Setters
    public Integer getFollowUpId() {
        return followUpId;
    }

    public void setFollowUpId(Integer followUpId) {
        this.followUpId = followUpId;
    }

    public Enquiry getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(Enquiry enquiry) {
        this.enquiry = enquiry;
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

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
