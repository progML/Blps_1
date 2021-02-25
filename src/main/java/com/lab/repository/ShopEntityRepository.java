package com.lab.repository;

import com.lab.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
public interface ShopEntityRepository extends JpaRepository<ShopEntity, Integer> {

    @Query(nativeQuery = true, value = "Select id, cashback, name from shop_table")
    List<ShopEntity> showShops();
}
