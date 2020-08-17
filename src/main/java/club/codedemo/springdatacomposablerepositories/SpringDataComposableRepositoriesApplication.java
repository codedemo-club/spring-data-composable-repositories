package club.codedemo.springdatacomposablerepositories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 注释掉的注解对应3.3小节
 * 若启用该注解
 * 则需要将CustomStudentRepositoryImpl重新命名为 CustomStudentRepositoryCustomImpl
 */
@SpringBootApplication
//@EnableJpaRepositories(
//        basePackages = "club.codedemo.springdatacomposablerepositories.repository",
//        repositoryImplementationPostfix = "CustomImpl")
public class SpringDataComposableRepositoriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataComposableRepositoriesApplication.class, args);
    }

}
