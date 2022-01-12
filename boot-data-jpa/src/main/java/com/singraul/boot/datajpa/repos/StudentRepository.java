package com.singraul.boot.datajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.boot.datajpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
