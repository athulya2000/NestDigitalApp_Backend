package com.example.NestDigitalApp_Backend.dao;

import com.example.NestDigitalApp_Backend.model.Security;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security,Integer> {

    @Query(value="SELECT `id`, `employeecode`, `name`, `password`, `username` FROM `security_guard` WHERE `username`= :username AND`password`= :password",nativeQuery = true)
    List<Security> SecurityLogin(@Param("username") String username,@Param("password") String password);

    @Query(value="SELECT `id`, `employeecode`, `name`, `password`, `username` FROM `security_guard` WHERE `id`= :id",nativeQuery = true)
    List<Security> ViewSecurityProfile(@Param("id") Integer id);
}
