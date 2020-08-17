package club.codedemo.springdatacomposablerepositories.repository;

import club.codedemo.springdatacomposablerepositories.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends
        JpaRepository<Student, Long>,
        CustomStudentRepository,
        CustomTeacherRepository {

    /**
     * 条件查询
     *
     * @param name 姓名
     * @return
     */
    List<Student> findByName(String name);

    /**
     * 该方法被CustomStudentRepository覆盖，不会执行
     * @param id
     * @param name
     * @return
     */
    @Override
    List<Student> findByIdOrName(Long id, String name);
}
