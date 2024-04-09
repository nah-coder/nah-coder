package com.example.demo.studentRepository;

import com.example.demo.entity.Student;
import com.example.demo.projection.IStudentPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select s from Student s where s.address like concat('%',:address,'%') ")
    List<Student> findByAddress(@Param("address") String address);
    @Query(value = "select s from Student s where s.point like concat('%',:point,'%') ")
    List<Student> findByPoint(@Param("point") String point);
    @Query(value = "select s from Student s where s.address like concat('%',:point,'%') ")
    List<Student> findBypoint(@Param("point") String point);

    //@Query(value = "select s from Student s where s.id like concat('%',:id,'%') ")
    //List<Student> findStudentByID(@Param("id") String id);

    @Query(value = "select concat(s.last_name , '',s.first_name) name,\n" +
            "       s.address address,\n" +
            "       c.name clazzName,\n" +
            "       s2.name subjectName,\n" +
            "       ss.point point\n" +
            "       from student s\n" +
            "left join clazz c on s.clazz_id=c.id\n" +
            "left join student_subject ss on s.id=ss.id_student\n" +
            "left join subject s2 on s2.id=ss.id_subject\n" +
            "\n" +
            "where s.id=1",nativeQuery = true )
    List<IStudentPoint> findStudentByID();

//    @Query(value = "SELECT AVG(point) AS AverageScore\n" +
//            "FROM student")
//    List<Student> findBypoint(@Param("point") String point);
}
