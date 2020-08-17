package club.codedemo.springdatacomposablerepositories.repository;

import club.codedemo.springdatacomposablerepositories.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomTeacherRepositoryImpl implements CustomTeacherRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void deleteTeacherByStudent(Student student) {
        if (student != null) {
            this.entityManager.remove(student.getTeacher());
        }
    }

    /**
     * 与CustomStudentRepository中的方法相同
     * 该方法优先级小于CustomStudentRepository中的同名方法
     * 所以该方法不会被执行
     *
     * @param name
     * @param id
     * @return
     */
    @Override
    public List<Student> findByNameOrId(String name, Long id) {
        throw new RuntimeException();
    }
}
