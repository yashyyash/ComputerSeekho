package com.seekho.api.service;

import com.seekho.api.dto.EnquiryDTO;
import java.util.List;

public interface EnquiryService {
    EnquiryDTO createEnquiry(EnquiryDTO enquiryDTO);
    EnquiryDTO updateStatus(Integer enquiryId, String status);
    List<EnquiryDTO> getAllEnquiries();
    EnquiryDTO getEnquiryById(Integer id);
    void deleteEnquiry(Integer id);
}
