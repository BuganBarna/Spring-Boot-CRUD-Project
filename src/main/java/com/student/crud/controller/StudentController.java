package com.student.crud.controller;

import com.student.crud.entity.Student;
import com.student.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/add")
    public String addStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student",student);
        return "add_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student ) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        Student updatedStudent = studentService.getStudentById(id);
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setEmail(student.getEmail());
        updatedStudent.setNeptunId(student.getNeptunId());
        studentService.updateStudent(updatedStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/update/{id}")
    public String updateStudentForm(@PathVariable Long id, Model model) {
            model.addAttribute("student", studentService.getStudentById(id));
            return "update_student";
    }

    @GetMapping ("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentByid(id);
        return "redirect:/students";
    }

}
