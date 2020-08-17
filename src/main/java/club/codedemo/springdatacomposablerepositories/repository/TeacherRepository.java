package club.codedemo.springdatacomposablerepositories.repository;

import club.codedemo.springdatacomposablerepositories.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
