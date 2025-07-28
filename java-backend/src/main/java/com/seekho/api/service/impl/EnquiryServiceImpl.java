package com.seekho.api.service.impl;

import com.seekho.api.dto.EnquiryDTO;
import com.seekho.api.model.Enquiry;
import com.seekho.api.model.Course;
import com.seekho.api.model.Staff;
import com.seekho.api.repository.CourseRepository;
import com.seekho.api.repository.EnquiryRepository;
import com.seekho.api.repository.StaffRepository;
import com.seekho.api.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StaffRepository staffRepository;

    private EnquiryDTO convertToDTO(Enquiry enquiry) {
        EnquiryDTO dto = new EnquiryDTO();
        dto.setEnquiryId(enquiry.getEnquiryID());
        dto.setEnquirerName(enquiry.getEnquirerName());
        dto.setPhone(enquiry.getPhone());
        dto.setStatus(enquiry.getStatus());

        if (enquiry.getCourse() != null) {
            dto.setCourseId(enquiry.getCourse().getCourseId());
        }
        if (enquiry.getAssignedStaff() != null) {
            dto.setAssignedToStaffId(enquiry.getAssignedStaff().getStaffId());
        }

        return dto;
    }

    private Enquiry convertToEntity(EnquiryDTO dto) {
        Enquiry enquiry = new Enquiry();
        enquiry.setEnquiryID(dto.getEnquiryId());
        enquiry.setEnquirerName(dto.getEnquirerName());
        enquiry.setPhone(dto.getPhone());
        enquiry.setStatus(dto.getStatus());

        if (dto.getCourseId() != null) {
            Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
            enquiry.setCourse(course);
        }

        if (dto.getAssignedToStaffId() != null) {
            Staff staff = staffRepository.findById(dto.getAssignedToStaffId()).orElse(null);
            enquiry.setAssignedStaff(staff);
        }

        return enquiry;
    }

    public EnquiryDTO createEnquiry(EnquiryDTO enquiryDTO) {
        Enquiry enquiry = convertToEntity(enquiryDTO);
        Enquiry saved = enquiryRepository.save(enquiry);
        return convertToDTO(saved);
    }

    public EnquiryDTO updateStatus(Integer enquiryId, String status) {
        Optional<Enquiry> optional = enquiryRepository.findById(enquiryId);
        if (optional.isPresent()) {
            Enquiry enquiry = optional.get();
            enquiry.setStatus(status);
            enquiryRepository.save(enquiry);
            return convertToDTO(enquiry);
        }
        return null;
    }

    public List<EnquiryDTO> getAllEnquiries() {
        List<Enquiry> list = enquiryRepository.findAll();
        List<EnquiryDTO> result = new ArrayList<>();
        for (Enquiry e : list) {
            result.add(convertToDTO(e));
        }
        return result;
    }

    public EnquiryDTO getEnquiryById(Integer id) {
        Optional<Enquiry> optional = enquiryRepository.findById(id);
        return optional.map(this::convertToDTO).orElse(null);
    }

    public void deleteEnquiry(Integer id) {
        enquiryRepository.deleteById(id);
    }
}
