package cn.edu.nju.gyue.wxbackend.repository;

import cn.edu.nju.gyue.wxbackend.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    School findBySchoolId(Long schoolId);
}
