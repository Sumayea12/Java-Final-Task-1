package dev.service;

import dev.domain.StudentInfoValidation;
import dev.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    public void create(@Valid StudentInfoValidation student) throws SQLException {
        student.setname(student.getname().toUpperCase());
        studentRepository.create(student);
    }

    public List<StudentInfoValidation> showAll() throws SQLException {
        return studentRepository.showAll();
    }

    public void deleteUserById(int id) throws SQLException {
        studentRepository.deleteById(id);
    }

    public StudentInfoValidation showStudentDetails(int id) throws SQLException {
        return studentRepository.showStudentDetails(id);
    }


    public void EditUser(StudentInfoValidation student) throws SQLException {
        studentRepository.EditUser(student);

    }
}
