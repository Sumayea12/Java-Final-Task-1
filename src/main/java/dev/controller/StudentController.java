package dev.controller;

import dev.domain.Student;
import dev.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping
    public String showAllStudents(Model model) {
        // Fetch all students and add them to the model
        model.addAttribute("students", studentService.getAllStudents());
        return "all-students";
    }

    @RequestMapping("/{id}")
    public String showStudentDetails(@PathVariable("id") int id, Model model) {
        // Fetch a specific student by ID and add it to the model
        Student student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "student-details";
        } else {
            // Handle case where student with given ID is not found
            return "student-not-found";
        }
    }

    @RequestMapping("/{id}/edit")
    public String showEditStudentForm(@PathVariable("id") int id, Model model) {
        // Fetch a specific student by ID and add it to the model for editing
        Student student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "edit-student";
        } else {
            // Handle case where student with given ID is not found
            return "student-not-found";
        }
    }

    @RequestMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id") int id) {
        // Delete the student with the given ID
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }


}
