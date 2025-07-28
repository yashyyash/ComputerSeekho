package com.seekho.api.dto;

public class EnquiryDTO {
    private Integer enquiryId;
    private String enquirerName;
    private String phone;
    private Integer courseId;
    private Integer assignedToStaffId;
    private String status;

    public Integer getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(Integer enquiryId) {
        this.enquiryId = enquiryId;
    }

    public String getEnquirerName() {
        return enquirerName;
    }

    public void setEnquirerName(String enquirerName) {
        this.enquirerName = enquirerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getAssignedToStaffId() {
        return assignedToStaffId;
    }

    public void setAssignedToStaffId(Integer assignedToStaffId) {
        this.assignedToStaffId = assignedToStaffId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
