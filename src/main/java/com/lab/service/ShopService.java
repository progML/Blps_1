package com.lab.service;

import com.lab.entity.ShopEntity;
import com.lab.repository.ShopEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopEntityRepository shopEntityRepository;


    public List<ShopEntity> showShops(){
        System.out.println("---------");
        return shopEntityRepository.showShops();
    }
}
