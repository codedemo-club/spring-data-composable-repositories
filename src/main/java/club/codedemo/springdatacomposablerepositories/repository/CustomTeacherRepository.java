package club.codedemo.springdatacomposablerepositories.repository;

import club.codedemo.springdatacomposablerepositories.entity.Student;

import java.util.List;

public interface CustomTeacherRepository {
    void deleteTeacherByStudent(Student student);

    List<Student> findByNameOrId(String name, Long id);
}
