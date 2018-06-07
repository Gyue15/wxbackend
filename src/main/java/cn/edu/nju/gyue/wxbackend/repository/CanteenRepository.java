package cn.edu.nju.gyue.wxbackend.repository;

import cn.edu.nju.gyue.wxbackend.entity.Canteen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanteenRepository extends JpaRepository<Canteen, Long> {
    List<Canteen> findBySchool_SchoolId(Long schoolId);
}
