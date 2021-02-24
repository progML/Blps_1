package com.lab.repository;

import com.lab.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(String name);
}
