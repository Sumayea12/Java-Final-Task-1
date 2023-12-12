package dev.service;

import dev.domain.Student;
import dev.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) throws SQLException {
        // Any logic before saving the student entity can be added here
        studentRepository.create(student);
    }

    public Object getAllStudents() {
    }


    public Student getStudentById(int id) {
    }
}
