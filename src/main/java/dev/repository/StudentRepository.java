package dev.repository;

import dev.domain.StudentInfoValidation;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepository {

    private DataSource dataSource;

    public StudentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }



    public void create(@Valid StudentInfoValidation student) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (id,name, email, password, date_of_birth,gender,quota,country) VALUES (?, ?, ?, ?,?,?,?,?)");
        preparedStatement.setInt(1,student.getId());
        preparedStatement.setString(2, student.getname());
        preparedStatement.setString(3, student.getEmail());
        preparedStatement.setString(4, student.getPassword());
        preparedStatement.setDate(5, Date.valueOf(student.getDateOfBirth()));
        preparedStatement.setString(6, student.getGender());
        preparedStatement.setString(7, student.getQuota());
        preparedStatement.setString(8, student.getCountry());
        preparedStatement.execute();
    }

    public List<StudentInfoValidation> showAll() throws SQLException {
        List<StudentInfoValidation> studentList = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                StudentInfoValidation student = new StudentInfoValidation();
                student.setId((int) resultSet.getInt("id"));
                student.setname(resultSet.getString("full_name"));
                student.setEmail(resultSet.getString("email"));
                student.setDateOfBirth(LocalDate.parse(resultSet.getString("date_of_birth")));
                student.setGender(resultSet.getString("gender"));
                student.setQuota(resultSet.getString("quota"));
                student.setCountry(resultSet.getString("country"));


                studentList.add(student);
            }
        }

        return studentList;
    }
    public void deleteById(int userId) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        }
    }

    public StudentInfoValidation showStudentDetails(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        StudentInfoValidation student = new StudentInfoValidation();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    student = new StudentInfoValidation();
                    student.setId(resultSet.getInt("id"));
                    student.setname(resultSet.getString("full_name"));
                    student.setEmail(resultSet.getString("email"));
                    student.setDateOfBirth(LocalDate.parse(resultSet.getString("date_of_birth")));
                    student.setGender(resultSet.getString("gender"));
                    student.setQuota(resultSet.getString("quota"));
                    student.setCountry(resultSet.getString("country"));
                }
            }
        }

        return student;
    }

    public void EditUser(StudentInfoValidation student) throws SQLException {
        String sql = "UPDATE users SET full_name = ?, email = ? WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, student.getname());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getId());

            preparedStatement.execute();
        }
    }

}



