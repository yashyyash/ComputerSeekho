package com.seekho.api.service;

import com.seekho.api.dto.CourseDTO;
import java.util.List;

public interface CourseService {
    CourseDTO createCourse(CourseDTO courseDTO);
    CourseDTO getCourseById(Integer id);
    List<CourseDTO> getAllCourses();
    CourseDTO updateCourse(Integer id, CourseDTO courseDTO);
    void deleteCourse(Integer id);
}
