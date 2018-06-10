package cn.edu.nju.gyue.wxbackend.repository;

import cn.edu.nju.gyue.wxbackend.entity.OpenIdKitchen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenIdKitchenRepository extends JpaRepository<OpenIdKitchen, String> {
    OpenIdKitchen findByOpenId(String openId);
}
