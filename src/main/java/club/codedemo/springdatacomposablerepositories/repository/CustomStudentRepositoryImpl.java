package club.codedemo.springdatacomposablerepositories.repository;

import club.codedemo.springdatacomposablerepositories.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class CustomStudentRepositoryImpl implements CustomStudentRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void deleteStudent(Student student) {
        this.entityManager.remove(student);
    }

    /**
     * 该方法与JpaRepository中的相同
     * 优先级高于JpaRepository的findAll方法
     * 调用本方法时将发生异常
     *
     * @return
     */
    @Override
    public List<Student> findAll() {
        throw new RuntimeException();
    }

    /**
     * 该方法覆盖了StudentRepository中的同名方法，会被执行
     *
     * @param id   ID
     * @param name name
     * @return
     */
    @Override
    public List<Student> findByIdOrName(Long id, String name) {
        throw new RuntimeException();
    }

    /**
     * 与CustomTeacherRepository中的方法相同
     * 该方法优先级大于CustomTeacherRepository中的同名方法
     *
     * @param name
     * @param id
     * @return
     */
    @Override
    public List<Student> findByNameOrId(String name, Long id) {
        return new ArrayList<>();
    }
}
