package com.singraul.boot.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.singraul.boot.datajpa.entity.Student;
import com.singraul.boot.datajpa.repos.StudentRepository;

@SpringBootTest
class BootDataJpaApplicationTests {
	@Autowired
	StudentRepository studentRepository;

	@Test
	void testSaveStudent() {
		Student student = new Student();
		student.setStudentId(2L);
		student.setStudentName("Singraul");
		student.setStudentScore(76);
		
		studentRepository.save(student);
		
		Student studentSaved= studentRepository.findById(2L).get();
        // Testing If saved object is not null 
		Assert.notNull(studentSaved);
		Assert.hasText(studentSaved.getStudentName(), "Singraul");
		System.out.println(studentSaved);
		
	}

}
