package com.example.demo.studentService;

import com.example.demo.entity.Clazz;
import com.example.demo.entity.Student;
import com.example.demo.mapper.ClazzMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.projection.IStudentPoint;
import com.example.demo.studentDTO.StudentDTO;
import com.example.demo.studentRepository.ClazzRepository;
import com.example.demo.studentRepository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ClazzMapper clazzMapper;
    private final ClazzRepository clazzRepository;


    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }
//    public List<StudentDTO> findAll() {
//        List<StudentDTO> students = studentRepository.findAll();
//        return students;
//    }

    public List<IStudentPoint> findStudentByID(int id) {
        return studentRepository.findStudentByID();
    }

    public Student findById(int id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isEmpty()){
            System.out.println("Không tìm thấy sinh viên");
            return null;
        }
        return optionalStudent.get();
    }

    public List<StudentDTO> findbyaddress(String address) {
        List<Student> students = studentRepository.findByAddress(address);
        return studentMapper.toDto(students);
    }
//    public String save(StudentDTO studentDTO) {
//        Clazz clazz = clazzMapper.toEntity(studentDTO.getClazz());
//        clazz = clazzRepository.save(clazz);
//        Student student = studentMapper.toEntity(studentDTO);
//        student.setClazz(clazz);
//        studentRepository.save(student);
//        return "Thêm thành công";
//    }

    public String save(StudentDTO student){
        Student students = new Student();
//        String name = student.getName(); // "Nguyễn Duy";

        students.setLastName(students.getLastName());
        students.setFirstName(students.getFirstName());
        students.setAddress(student.getAddress());
        studentRepository.save(students);
        return "Thêm thành công";
    }

    public String update(int id , StudentDTO studentDTO){
        boolean existbyid = studentRepository.existsById(id);
//        Clazz clazz = clazzRepository.findById(studentDTO.getClazz().getId())
//                .orElse(new Clazz());
        if(!existbyid) return "không có sinh viên có id = " +id ;
//        if(!existbyid) return "ko có id nay ! ";
//        if(clazz.getId()=null) return "ko có lớp id = " +id;
//        List<String> strings =
            Student student = new Student();
            student.setId(id);
//            student.setFirstName(studentDTO.getFirstName());
//            student.setLastName(studentDTO.getLastName());
            student.setAddress(studentDTO.getAddress());
//            student.setClazz(studentDTO.getClazz());
            studentRepository.save(student);
            return "update thành công";
    }
//    public String update(int id, StudentDTO studentDTO) {
//        boolean existsById = studentRepository.existsById(id);
//        if (!existsById) return "Không có sinh viên có id = " +id;
//
//        Student student = new Student();
//        student.setId(id);
//        student.setLastName(studentDTO.getLastName());
//        student.setFirstName(studentDTO.getFirstName());
//        student.setAddress(studentDTO.getAddress());
//        studentRepository.save(student);
//        return "Cập nhật thành công";
//    }

//    public String delete(int id, StudentDTO studentDTO) {
//        boolean existbyid = studentRepository.existsById(id);
//        if (!existbyid) return "ko có id nay ! ";
//        Student student = new Student();
//        studentRepository.deleteById(id);
//        return "xóa thành công";
//    }

    public String delete (int id){
        boolean existsById = studentRepository.existsById(id);
        if (!existsById) return "Không có sinh viên có id = " +id;
        studentRepository.deleteById(id);
        return "Xóa thành công";
    }

//    public StudentDTO findStudentByID(int id){
//        List<IStudentPoint> iStudentPoint = studentRepository.findStudentByID();
//        StudentDTO dto = new StudentDTO();
//        dto.setName(iStudentPoint.get(0).getName());
//        dto.setPoint(iStudentPoint.get(0).getPoint());
//        dto.setAddress(iStudentPoint.get(0).getAddress());
////        dto.setClazz(iStudentPoint.get(0).getClass());
//
//        List<SubjectDTO> subjectDTOS = new ArrayList<>();
//        iStudentPoint.forEach(item -> {
//            SubjectDTO subjectDTO = new SubjectDTO();
//            subjectDTO.setName(item.getName());
//            subjectDTO.setPoint(item.getPoint());
//            subjectDTO.setAdress(item.getAddress());
////            subjectDTO.setClazz(item.getClass());
//        });
//        dto.setSubjectDTOS(subjectDTOS);
//
//        return dto;
//    }
}
