package com.seekho.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "enquiries")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enquiryID;

    private String enquirerName;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "courseID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "assignedToStaffID")
    private Staff assignedStaff;

    private String status;

    // Getters and Setters
    public int getEnquiryID() { return enquiryID; }
    public void setEnquiryID(int enquiryID) { this.enquiryID = enquiryID; }

    public String getEnquirerName() { return enquirerName; }
    public void setEnquirerName(String enquirerName) { this.enquirerName = enquirerName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public Staff getAssignedStaff() { return assignedStaff; }
    public void setAssignedStaff(Staff assignedStaff) { this.assignedStaff = assignedStaff; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
