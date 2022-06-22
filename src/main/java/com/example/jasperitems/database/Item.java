package com.example.jasperitems.database;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



@Setter
@Getter
@Entity
@Data
@Table(name = "items")
public class Item {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_name", nullable = false)
    private String item_name;
    @Column(name = "price", nullable = false)
    private float price;


    public Item(String item_name, float price) {
        this.item_name = item_name;
        this.price = price;
    }


    public Item(Long id, String item_name, float price) {
        this.id = id;
        this.item_name = item_name;
        this.price = price;
    }
}
