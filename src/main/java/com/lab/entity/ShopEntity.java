package com.lab.entity;


import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Table(name = "shop_table")
@Data
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private float cashback;


}
