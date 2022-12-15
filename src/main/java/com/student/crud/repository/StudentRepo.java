package com.student.crud.repository;

import com.student.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo  extends JpaRepository<Student, Long> {
}
