package cn.edu.nju.gyue.wxbackend.repository;

import cn.edu.nju.gyue.wxbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsernameAndPassword(String username, String password);

    Student findByUsername(String username);
}
