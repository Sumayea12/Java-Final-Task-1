package dev.repository;

import dev.domain.Student;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class StudentRepository {

    private DataSource dataSource;

    public StudentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create(Student student) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (name, email, date_of_birth, gender, quota, country) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));
            preparedStatement.setString(4, student.getGender().name());
            preparedStatement.setString(5, student.getQuota());
            preparedStatement.setString(6, student.getCountry());
            preparedStatement.executeUpdate();
        }
    }

    // Other CRUD operations as needed
}
