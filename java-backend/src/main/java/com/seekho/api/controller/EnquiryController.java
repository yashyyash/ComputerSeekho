package com.seekho.api.controller;

import com.seekho.api.dto.EnquiryDTO;
import com.seekho.api.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enquiries")
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @PostMapping
    public EnquiryDTO createEnquiry(@RequestBody EnquiryDTO dto) {
        return enquiryService.createEnquiry(dto);
    }

    @GetMapping
    public List<EnquiryDTO> getAll() {
        return enquiryService.getAllEnquiries();
    }

    @GetMapping("/{id}")
    public EnquiryDTO getById(@PathVariable Integer id) {
        return enquiryService.getEnquiryById(id);
    }

    @PutMapping("/{id}/status")
    public EnquiryDTO updateStatus(@PathVariable Integer id, @RequestParam String status) {
        return enquiryService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        enquiryService.deleteEnquiry(id);
    }
}
