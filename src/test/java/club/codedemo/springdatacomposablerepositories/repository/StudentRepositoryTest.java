package club.codedemo.springdatacomposablerepositories.repository;

import club.codedemo.springdatacomposablerepositories.entity.Student;
import club.codedemo.springdatacomposablerepositories.entity.Teacher;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Random;


@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @Test
    void findByName() {
        Student student = new Student();
        String name = RandomString.make(4);
        student.setName(name);
        this.studentRepository.save(student);

        Assertions.assertEquals(name,
                this.studentRepository.findByName(student.getName()).get(0).getName());
    }

    @Test
    void deleteStudent() {
        Student student = new Student();
        student.setName(RandomString.make(4));
        this.studentRepository.save(student);
        Assertions.assertTrue(this.studentRepository.existsById(student.getId()));

        this.studentRepository.deleteStudent(student);
        Assertions.assertFalse(this.studentRepository.existsById(student.getId()));
    }

    @Test
    void deleteTeacherByStudent() {
        Teacher teacher = new Teacher();
        teacher.setName(RandomString.make(4));
        this.teacherRepository.save(teacher);
        Assertions.assertTrue(this.teacherRepository.existsById(teacher.getId()));

        Student student = new Student();
        student.setName(RandomString.make(4));
        student.setTeacher(teacher);

        this.studentRepository.deleteTeacherByStudent(student);
        Assertions.assertFalse(this.teacherRepository.existsById(teacher.getId()));
    }

    /**
     * 执行findAll方法发生了异常
     * 说明自定义仓库中的方法优先级高于JpaRepository
     */
    @Test
    void findAll() {
        Assertions.assertThrows(RuntimeException.class,
                () -> this.studentRepository.findAll());
    }

    /**
     * 执行findByIdOrName未发生异常
     * 说明CustomStudentRepository优先级高于StudentRepository
     */
    @Test
    void findByIdOrName() {
        Assertions.assertThrows(RuntimeException.class,
                () -> this.studentRepository.findByIdOrName(new Random().nextLong(), RandomString.make(4)));
    }

    /**
     * 执行findByIdOrName未发生异常
     * 说明CustomStudentRepository的优先级高于CustomTeacherRepository
     */
    @Test
    void findNameOrId() {
        this.studentRepository.findByNameOrId(RandomString.make(4), new Random().nextLong());
    }

}