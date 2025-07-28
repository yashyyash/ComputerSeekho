package com.seekho.api.service.impl;

import com.seekho.api.dto.CourseDTO;
import com.seekho.api.model.Course;
import com.seekho.api.repository.CourseRepository;
import com.seekho.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    private CourseDTO toDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setCourseId(course.getCourseId());
        dto.setCourseName(course.getCourseName());
        dto.setCourseDetails(course.getCourseDetails());
        dto.setIsActive(course.getIsActive());
        return dto;
    }

    private Course toEntity(CourseDTO dto) {
        Course course = new Course();
        course.setCourseId(dto.getCourseId());
        course.setCourseName(dto.getCourseName());
        course.setCourseDetails(dto.getCourseDetails());
        course.setIsActive(dto.getIsActive());
        return course;
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course saved = courseRepository.save(toEntity(courseDTO));
        return toDTO(saved);
    }

    @Override
    public CourseDTO getCourseById(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        return toDTO(course);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<CourseDTO> result = new ArrayList<>();
        for (Course c : courseRepository.findAll()) {
            result.add(toDTO(c));
        }
        return result;
    }

    @Override
    public CourseDTO updateCourse(Integer id, CourseDTO dto) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.setCourseName(dto.getCourseName());
        course.setCourseDetails(dto.getCourseDetails());
        course.setIsActive(dto.getIsActive());
        return toDTO(courseRepository.save(course));
    }

    @Override
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
