package cn.edu.nju.gyue.wxbackend.repository;

import cn.edu.nju.gyue.wxbackend.entity.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WindowRepository extends JpaRepository<Window, Long> {
    List<Window> findByCanteen_CanteenId(Long canteenId);
}
