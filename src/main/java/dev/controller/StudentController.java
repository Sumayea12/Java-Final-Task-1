package dev.controller;

import dev.domain.StudentInfoValidation;
import dev.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @InitBinder
    public void intiBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/create")
    public String fourth(Model model) {
        model.addAttribute("user", new StudentInfoValidation());

        return "registration";
    }
    @RequestMapping("/Students")
    public String getAllUsers(Model model) throws SQLException {
        List<StudentInfoValidation> students = studentService.showAll();
        model.addAttribute("users", students);
        return "allStudent";
    }

    @RequestMapping("/store")
    public String fifth(@Valid @ModelAttribute("user") StudentInfoValidation student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        else {
            studentService.create(student);
            return "confirm";
        }
    }
    @RequestMapping("/students/{id}")
    public String showStudentDetails(@PathVariable int id, Model model) throws SQLException {
        StudentInfoValidation student = studentService.showStudentDetails(id);
        if (student == null) {
            return "studentNotFound";
        }
        model.addAttribute("users", student);
        return "studentDetails";
    }

    @RequestMapping(value = "/students/{id}/delete")
    public String deleteUser(@PathVariable int id) throws SQLException {
        studentService.deleteUserById(id);
        return "redirect:/Students";

    }
    @RequestMapping(value = "/students/{id}/edit")
    public String EditUser(@PathVariable int id, Model model) throws SQLException {

        StudentInfoValidation student = studentService.showStudentDetails(id);
        if (student == null) {
            return "studentNotFound";
        }
        model.addAttribute("users", student);
        return "studentDetailsEdit";

    }
    @RequestMapping("/updateStudent")
    public String EditUser(@ModelAttribute StudentInfoValidation student) throws SQLException {
        studentService.EditUser(student);
        return "redirect:/Students";
    }

}
