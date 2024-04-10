package com.example.demo.studentController;

import com.example.demo.entity.Student;
import com.example.demo.projection.IStudentPoint;
import com.example.demo.studentDTO.StudentDTO;
import com.example.demo.studentRepository.StudentRepository;
import com.example.demo.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/huyhehe")
public class studentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("")
    public List<Student> findAll(){

        return studentService.findAll();
    }
//    public List<Student> findAll(){
//
//        return studentService.findAll();
//    }
    @GetMapping("/address")
    public List<StudentDTO> findbyaddress(@RequestParam("address") String address){
        return studentService.findbyaddress(address);
    }
    @PostMapping("")
    String save(@RequestBody StudentDTO studentDTO){
        String message = studentService.save(studentDTO);
        return message;
    }

//    @PutMapping("")
//    String update(@RequestParam("id")int id,@RequestBody StudentDTO studentDTO){
//        String message = studentService.update(id, studentDTO);
//        return message;
//    }

    @DeleteMapping("")
    String delete(@RequestParam("id")int id,@RequestBody StudentDTO studentDTO){
        String message = studentService.delete(id);
        return message;
    }

    @GetMapping("/{id}")
    List<IStudentPoint> findStudentByID(@PathVariable int id){
        return studentService.findStudentByID(id);
    }
}
