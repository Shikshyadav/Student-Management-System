package com.shi.studentmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shi.studentmanagement.model.Courses;

@Repository
public interface CourseRepo extends JpaRepository<Courses, Long> {

}
