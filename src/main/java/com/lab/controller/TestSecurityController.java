package com.lab.controller;

import com.lab.entity.ShopEntity;
import com.lab.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestSecurityController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/admin/get")
    public String getAdmin() {
        return "Hi admin";
    }

    @GetMapping("/user/shops")
    public ResponseEntity<List<ShopEntity>> getShops() {
        return new ResponseEntity<>(shopService.showShops(),  HttpStatus.OK);
    }
}
