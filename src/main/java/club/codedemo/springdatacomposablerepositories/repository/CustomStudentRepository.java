package club.codedemo.springdatacomposablerepositories.repository;

import club.codedemo.springdatacomposablerepositories.entity.Student;

import java.util.List;

/**
 * 自定义学生仓库，该仓库做为为基础仓库的补充
 */
public interface CustomStudentRepository {


    /**
     * 删除学生
     *
     * @param student 学生
     */
    void deleteStudent(Student student);



    List<Student> findAll();

    List<Student> findByIdOrName(Long id, String name);

    List<Student> findByNameOrId(String name, Long id);
}
