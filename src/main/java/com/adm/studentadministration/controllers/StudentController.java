package com.adm.studentadministration.controllers;

import com.adm.studentadministration.models.Student;
import com.adm.studentadministration.repositories.IStudentRepository;
import com.adm.studentadministration.repositories.InMemoryStudentRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    private IStudentRepository studentRepository;

    public StudentController() {
        studentRepository = new InMemoryStudentRepositoryImpl();
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("students", studentRepository.readAll());
        return "index";
    }

    //Very simple prototype of GET-request with parameter
    //https://www.baeldung.com/spring-request-param
    //TODO Direct to detailed view of student
    @GetMapping("/student")
    @ResponseBody
    public String getStudentByParameter(@RequestParam int id)
    {
        Student stu = studentRepository.read(id);
        return "The name is: "+ stu.getFirstName() + " and the CPRnumber is " + stu.getCpr();
    }
}