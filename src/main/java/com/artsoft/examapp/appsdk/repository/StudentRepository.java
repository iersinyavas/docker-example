package com.artsoft.examapp.appsdk.repository;

import com.artsoft.examapp.appsdk.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
