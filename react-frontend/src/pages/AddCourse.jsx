import React, { useState } from "react";
import "./AddCourse.css";

const AddCourse = () => {
  const [formData, setFormData] = useState({
    course_name: "",
    course_description: "",
    course_duration: "",
    course_fees: "",
    course_syllabus: "",
    age_grp_type: "",
    course_is_active: true,
    cover_photo: ""
  });

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === "checkbox" ? checked : value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Submitted Course Data:", formData);
    alert("Course Added!");
    // API call or data post logic here
  };

  return (
    <div className="add-course-container">
      <h2 className="form-heading">Add New Course</h2>
      <form className="add-course-form" onSubmit={handleSubmit}>
        <label>
          Course Name:
          <input type="text" name="course_name" value={formData.course_name} onChange={handleChange} required />
        </label>

        <label>
          Description:
          <input type="text" name="course_description" value={formData.course_description} onChange={handleChange} />
        </label>

        <label>
          Duration (months):
          <input type="number" name="course_duration" value={formData.course_duration} onChange={handleChange} />
        </label>

        <label>
          Fees:
          <input type="number" name="course_fees" value={formData.course_fees} onChange={handleChange} />
        </label>

        <label>
          Syllabus:
          <textarea name="course_syllabus" value={formData.course_syllabus} onChange={handleChange} />
        </label>

        <label>
          Age Group Type:
          <input type="text" name="age_grp_type" value={formData.age_grp_type} onChange={handleChange} />
        </label>

        <label>
          Is Active:
          <input type="checkbox" name="course_is_active" checked={formData.course_is_active} onChange={handleChange} />
        </label>

        <label>
          Cover Photo URL:
          <input type="text" name="cover_photo" value={formData.cover_photo} onChange={handleChange} />
        </label>

        <button type="submit" className="submit-btn">Add Course</button>
      </form>
    </div>
  );
};

export default AddCourse;
