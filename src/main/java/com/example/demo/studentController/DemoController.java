package com.example.demo.studentController;

import com.example.demo.entity.Student;
import com.example.demo.projection.IStudentPoint;
import com.example.demo.studentDTO.StudentDTO;
import com.example.demo.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/index")
    public String showIndex(Model model) {
        model.addAttribute("name", "Anh Huy");
        return "index";
    }

    @GetMapping("/show-student")
    public String showStudent(Model model) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName("Huy");
        studentDTO.setAddress("Đống Đa");
        model.addAttribute("studentDTO", studentDTO);
        return "index";
    }
//
    @GetMapping("/address")
    public String Showaddress(@RequestParam("address") String address, Model model) {
        List<StudentDTO> studentDTOS = studentService.findbyaddress(address);
        model.addAttribute("studentDTOS", studentDTOS);
        return "index";
    }

//
    @GetMapping("/findbyid")
    public String findbyid(@PathVariable int id, Model model) {
        List<IStudentPoint> Student = studentService.findStudentByID(id);
        model.addAttribute("studentDTOS", Student);
        return "index";
    }

//    @GetMapping("/view/student")
//    public String findAll(Model model) {
//        List<StudentDTO> studentDTO = studentService.findAll();
//        model.addAttribute("studentDTOS_All", studentDTO);
//        return "index";
//    }

    @GetMapping("/view/student")
    public String findAll(Model model) {
        List<Student> student = studentService.findAll();
        model.addAttribute("studentDTOS_All", student);
        return "index";
    }

    @GetMapping("/view/add-student")
    public String showAddStudent(Model model) {
        model.addAttribute("student",new Student());
        return "add-student";
    }

    @PostMapping("/student_save")
    public String addStudent(@ModelAttribute("student") StudentDTO student) {
        studentService.save(student);
        return "redirect:/view/student";
    }
}
